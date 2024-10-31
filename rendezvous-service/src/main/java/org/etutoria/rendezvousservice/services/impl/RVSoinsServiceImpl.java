package org.etutoria.rendezvousservice.services.impl;

import lombok.AllArgsConstructor;
import org.etutoria.rendezvousservice.entities.RV;
import org.etutoria.rendezvousservice.entities.RV_Soins;
import org.etutoria.rendezvousservice.facture.Facture;
import org.etutoria.rendezvousservice.facture.FactureClient;
import org.etutoria.rendezvousservice.facture.FactureDto;
import org.etutoria.rendezvousservice.repositories.RVDao;
import org.etutoria.rendezvousservice.repositories.RV_SoinsDao;
import org.etutoria.rendezvousservice.services.IRV_Soins;
import org.etutoria.rendezvousservice.soins.Soins;
import org.etutoria.rendezvousservice.soins.SoinsClient;
import org.etutoria.rendezvousservice.soins.SoinsDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RVSoinsServiceImpl implements IRV_Soins {
    private final RVDao rvRepository;
    private final RV_SoinsDao rvSoinsRepository;
    private final SoinsClient soinsClient;
    private final FactureClient factureClient;

    @Override
    public RV_Soins createRVSoins(Long rvId, Long soinsId, Long factureId) {
        // Récupération de RV
        RV rv = rvRepository.findById(rvId)
                .orElseThrow(() -> new RuntimeException("RV not found"));

        // Récupération de Soins depuis le microservice
        SoinsDto soinsDto = soinsClient.getSoinsById(soinsId)
                .orElseThrow(() -> new RuntimeException("Soins not found"));

        // Récupération de Facture depuis le microservice
        FactureDto factureDto = factureClient.getFactureById(factureId)
                .orElseThrow(() -> new RuntimeException("Facture not found"));

        // Création de l'objet RV_Soins
        RV_Soins rvSoins = new RV_Soins();
        rvSoins.setRv(rv);
        rvSoins.setSoinsId(soinsDto.getSoinsId());
        rvSoins.setFactureId(factureDto.getFactureId());

        // Sauvegarde de RV_Soins
        return rvSoinsRepository.save(rvSoins);
    }


    @Override
    public List<RV_Soins> listAllRVSoins() {
        return rvSoinsRepository.findAll();
    }
}