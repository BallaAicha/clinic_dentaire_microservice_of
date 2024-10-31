package org.etutoria.facture.services.impl;
import org.etutoria.facture.dtos.FactureDto;
import org.etutoria.facture.mappers.FactureMapper;
import org.etutoria.facture.repositories.FactureDao;
import org.etutoria.facture.services.IFactureService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FactureServiceImpl implements IFactureService {
    private final FactureDao factureDao;
    private final FactureMapper factureMapper;

    public FactureServiceImpl(FactureDao factureDao, FactureMapper factureMapper) {
        this.factureDao = factureDao;
        this.factureMapper = factureMapper;
    }

    @Override
    public List<FactureDto> listFactures() {
        return factureDao.findAll().stream().map(factureMapper::fromFacture).collect(java.util.stream.Collectors.toList());
    }

    @Override
    public FactureDto createFacture(FactureDto factureDto) {
        return factureMapper.fromFacture(factureDao.save(factureMapper.fromFactureDto(factureDto)));
    }

    @Override
    public FactureDto getFacture(Long factureId) {
        return factureDao.findById(factureId).map(factureMapper::fromFacture).orElse(null);
    }
}
