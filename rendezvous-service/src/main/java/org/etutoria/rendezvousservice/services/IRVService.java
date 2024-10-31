package org.etutoria.rendezvousservice.services;

import org.etutoria.rendezvousservice.dtos.RVDto;

import java.util.List;

public interface IRVService {
    RVDto createRV(RVDto rvDto);
    List<RVDto> listAllRVs();

}
