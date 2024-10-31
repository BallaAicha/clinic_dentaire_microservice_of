package org.etutoria.rendezvousservice.soins;

import org.etutoria.rendezvousservice.patient.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(
        name = "soins-service",
        url = "${application.config.soins-url}",
        configuration = FeignClientConfig.class
)
public interface SoinsClient {
    @GetMapping("/{soinsId}")
    Optional<SoinsDto> getSoinsById(@PathVariable("soinsId") Long soinsId);
}
