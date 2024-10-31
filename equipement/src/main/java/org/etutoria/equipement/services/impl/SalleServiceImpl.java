package org.etutoria.equipement.services.impl;

import org.etutoria.equipement.dtos.SalleDto;
import org.etutoria.equipement.mappers.SalleMapper;
import org.etutoria.equipement.repositories.SalleDao;
import org.etutoria.equipement.services.IsalleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SalleServiceImpl implements IsalleService {
    private final SalleDao salleDao;
    private final SalleMapper salleMapper;

    public SalleServiceImpl(SalleDao salleDao, SalleMapper salleMapper) {
        this.salleDao = salleDao;
        this.salleMapper = salleMapper;
    }

    @Override
    public List<SalleDto> listAllSalles() {
        return salleDao.findAll().stream().map(salleMapper::fromSalle).collect(Collectors.toList());
    }
}
