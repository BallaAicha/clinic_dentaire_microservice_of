package org.etutoria.rendezvousservice.facture;

import org.etutoria.rendezvousservice.patient.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(
        name = "facture",
        url = "${application.config.facture-url}",
        configuration = FeignClientConfig.class
)
public interface FactureClient {

    @GetMapping("/{factureId}")
    Optional<FactureDto> getFactureById(@PathVariable("factureId") Long factureId);

}
