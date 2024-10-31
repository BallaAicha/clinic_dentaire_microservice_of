package org.etutoria.rendezvousservice.facture;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(name = "Facture", description = "Schema to hold Facture information")
@Data
public class FactureDto {
    @Schema(description = "ID of the facture", example = "1")
    private Long factureId;

    @Schema(description = "Montant of the facture", example = "100")
    @NotEmpty(message = "Montant cannot be null or empty")
    private Double montant;

    @Schema(description = "Date of the facture", example = "2021-12-31T23:59:59")
    @NotEmpty(message = "Date cannot be null or empty")
    private LocalDateTime dateEmission;


}
