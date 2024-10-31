package org.etutoria.usersservice.salle;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(
        name = "equipment",
        url = "http://localhost:8050/api/v1/equipments/salles"
)
public interface SalleClient {
    @GetMapping
    @CircuitBreaker(name = "equipmentService", fallbackMethod = "getDefaultSalle")
    List<SalleDto> listAllSalles();

    default List<SalleDto> getDefaultSalle(Exception exception) {
      SalleDto salle = new SalleDto();
        salle.setSalleId(0L);
        salle.setNom("Unkonwn Salle");
        return List.of(salle);
    }
}