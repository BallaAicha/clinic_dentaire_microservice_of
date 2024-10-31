package org.etutoria.equipement.dtos;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(name = "Machine", description = "Schema to hold Machine information")
@Data
public class MachineDto {
    @Schema(description = "ID of the machine", example = "1")
    private Long machineId;
    @Schema(description = "Nom of the machine", example = "Machine 1")
    @Size(max = 45, message = "Nom must be at most 45 characters")
    @NotEmpty(message = "Nom cannot be null or empty")
    private String nom;
    @Schema(description = "Description of the machine", example = "Machine 1")
    @Size(max = 45, message = "Description must be at most 45 characters")
    @NotEmpty(message = "Description cannot be null or empty")
    private String description;
}
