package org.etutoria.equipement.dtos;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(name = "Salle", description = "Schema to hold Salle information")
@Data
public class SalleDto {
    @Schema(description = "ID of the salle", example = "1")
    private Long salleId;
    @NotEmpty(message = "Name cannot be null or empty")
    @Schema(description = "Name of the salle", example = "Salle 1")
    @Size(max = 45, message = "Name must be at most 45 characters")
    private String nom;

}
