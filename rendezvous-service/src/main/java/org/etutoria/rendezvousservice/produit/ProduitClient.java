package org.etutoria.rendezvousservice.produit;

import org.etutoria.rendezvousservice.patient.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(
        name = "equipment",
        url = "${application.config.equipment-url}",
        configuration = FeignClientConfig.class
)
public interface ProduitClient {
    @GetMapping
    List<ProduitDto> listAllProduits();
}
