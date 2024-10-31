package org.etutoria.rendezvousservice.controller;

import lombok.AllArgsConstructor;
import org.etutoria.rendezvousservice.entities.RV_Soins;
import org.etutoria.rendezvousservice.services.IRV_Soins;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/rendezvous/rvsoins")
@CrossOrigin("*")
@AllArgsConstructor
public class RVSoinsController {
    private final IRV_Soins rvSoinsService;

    @GetMapping
    public List<RV_Soins> listRvSoins() {
        return rvSoinsService.listAllRVSoins();
    }

    @PostMapping
    public RV_Soins createRvSoins(@RequestBody RV_Soins rvSoins) {
        return rvSoinsService.createRVSoins(rvSoins.getRv().getRvId(), rvSoins.getSoinsId(), rvSoins.getFactureId());
    }

}