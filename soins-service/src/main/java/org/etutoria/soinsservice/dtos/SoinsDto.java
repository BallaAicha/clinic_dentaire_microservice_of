package org.etutoria.soinsservice.dtos;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
@Schema(name = "Soins", description = "Schema to hold Soins information")
@Data
public class SoinsDto {
    @Schema(description = "ID of the soins", example = "1")
    private Long soinsId;
    @Schema(description = "Description of the soins", example = "Soins dentaires")
    @NotEmpty(message = "Description cannot be null or empty")
    @Size(max = 45, message = "Description must be at most 45 characters")
    private String description;
}
