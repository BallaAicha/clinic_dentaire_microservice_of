package org.etutoria.soinsservice.services;

import org.etutoria.soinsservice.dtos.SoinsDto;

import java.util.List;

public interface SoinsService {
    public List<SoinsDto> listSoins();
    SoinsDto createSoins(SoinsDto soinsDto);
    SoinsDto getSoins(Long soinsId);

}
