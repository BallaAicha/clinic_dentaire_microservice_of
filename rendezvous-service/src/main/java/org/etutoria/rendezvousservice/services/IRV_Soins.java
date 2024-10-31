package org.etutoria.rendezvousservice.services;

import org.etutoria.rendezvousservice.entities.RV_Soins;

import java.util.List;

public interface IRV_Soins {
    RV_Soins createRVSoins(Long rvId, Long soinsId, Long factureId);
    List<RV_Soins> listAllRVSoins();

}
