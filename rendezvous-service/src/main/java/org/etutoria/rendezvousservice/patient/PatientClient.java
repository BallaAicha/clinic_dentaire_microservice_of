package org.etutoria.rendezvousservice.patient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(
        name = "patient-service",
        url = "${application.config.patient-url}",
        configuration = FeignClientConfig.class

)
public interface PatientClient {
    @GetMapping
    List<PatientDto> listAllPatients();
}
