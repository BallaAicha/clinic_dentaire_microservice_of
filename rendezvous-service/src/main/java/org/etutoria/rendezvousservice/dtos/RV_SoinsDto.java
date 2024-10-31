package org.etutoria.rendezvousservice.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.etutoria.rendezvousservice.facture.FactureDto;
import org.etutoria.rendezvousservice.soins.SoinsDto;


@Schema(name = "RV_Soins", description = "Schema to hold RV_Soins information")
@Data
public class RV_SoinsDto {
    @Schema(description = "ID of the RV_Soins", example = "1")
    private Long rvSoinsId;
    @Schema(description = "Rendez-vous associated with the RV_Soins")
    private RVDto rv;
    @Schema(description = "Soins associated with the RV_Soins")
    private SoinsDto soins;
    @Schema(description = "Facture associated with the RV_Soins")
    @NotEmpty(message = "Facture cannot be null or empty")
    @Size(max = 45, message = "Facture must be at most 45 characters")
    private FactureDto facture;
}
