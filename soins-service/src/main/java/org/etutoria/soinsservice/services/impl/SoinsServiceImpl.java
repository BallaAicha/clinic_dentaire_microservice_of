package org.etutoria.soinsservice.services.impl;

import org.etutoria.soinsservice.dtos.SoinsDto;
import org.etutoria.soinsservice.entities.Soins;
import org.etutoria.soinsservice.mappers.SoinsMapper;
import org.etutoria.soinsservice.repositories.SoinsDao;
import org.etutoria.soinsservice.services.SoinsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class SoinsServiceImpl implements SoinsService {
    private final SoinsDao soinsDao;
    private final SoinsMapper soinsMapper;

    public SoinsServiceImpl(SoinsDao soinsDao, SoinsMapper soinsMapper) {
        this.soinsDao = soinsDao;
        this.soinsMapper = soinsMapper;
    }


    @Override
    public List<SoinsDto> listSoins() {
        return soinsDao.findAll().stream().map(soinsMapper::fromSoins).collect(Collectors.toList());

    }

    @Override
    public SoinsDto createSoins(SoinsDto soinsDto) {
        // Create and save Soins
        Soins soins = new Soins();
        soins.setDescription(soinsDto.getDescription());
        soins.setCode(generateUniqueCode());
        soinsDao.save(soins);
        return soinsMapper.fromSoins(soins);
    }

    @Override
    public SoinsDto getSoins(Long soinsId) {
        Soins soins = soinsDao.findById(soinsId).orElseThrow(() -> new RuntimeException("Soins not found"));
        return soinsMapper.fromSoins(soins);
    }


    private String generateUniqueCode() {
        return UUID.randomUUID().toString();
    }
}
