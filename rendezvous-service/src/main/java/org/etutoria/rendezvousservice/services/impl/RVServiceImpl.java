package org.etutoria.rendezvousservice.services.impl;

import lombok.RequiredArgsConstructor;
import org.etutoria.rendezvousservice.dentiste.DentisteClient;
import org.etutoria.rendezvousservice.dtos.RVDto;
import org.etutoria.rendezvousservice.entities.RV;
import org.etutoria.rendezvousservice.mappers.RVMapper;
import org.etutoria.rendezvousservice.patient.PatientClient;
import org.etutoria.rendezvousservice.patient.PatientDto;
import org.etutoria.rendezvousservice.produit.ProduitClient;
import org.etutoria.rendezvousservice.repositories.RVDao;
import org.etutoria.rendezvousservice.services.IRVService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RVServiceImpl implements IRVService {
    private final RVDao rvDao;
    private final RVMapper rvMapper;
    private final DentisteClient dentisteClient;
    private final PatientClient patientClient;
    private final ProduitClient produitClient;

    @Override
    public RVDto createRV(RVDto rvDto) {
        // Fetch related entities
        var dentiste = dentisteClient.getDentistes().stream()
                .filter(d -> d.getDentisteId().equals(rvDto.getDentisteId()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Dentist not found"));

        var patient = patientClient.listAllPatients().stream()
                .filter(p -> p.getPatientId().equals(rvDto.getPatientId()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        var produits = produitClient.listAllProduits().stream()
                .filter(p -> rvDto.getProduitIds().contains(p.getProduitId()))
                .collect(Collectors.toSet());

        // Map DTO to entity
        RV rv = rvMapper.toEntity(rvDto);

        // Populate RV entity with fetched data
        rv.setDentisteId(dentiste.getDentisteId());
        rv.setPrenom(dentiste.getPrenom());
        rv.setSpecialite(dentiste.getSpecialite());
        rv.setTelephone(dentiste.getTelephone());

        rv.setPatientId(patient.getPatientId());
        rv.setFirstName(patient.getFirstName());
        rv.setLastName(patient.getLastName());

        // Assuming you want to store only one product's details in RV entity
        if (!produits.isEmpty()) {
            var produit = produits.iterator().next();
            rv.setProduitId(produit.getProduitId());
            rv.setNom(produit.getNom());
            rv.setDescription(produit.getDescription());
        }

        // Save entity
        RV savedRV = rvDao.save(rv);

        // Map entity back to DTO
        return rvMapper.toDto(savedRV);
    }

    @Override
    public List<RVDto> listAllRVs() {
        return rvDao.findAll().stream()
                .map(rvMapper::toDto)
                .collect(Collectors.toList());

    }
}