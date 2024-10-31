package org.etutoria.rendezvousservice.dentiste;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(name = "Dentiste", description = "Schema to hold Dentiste information")
@Data
public class DentisteDto {
    @Schema(description = "ID of the dentiste", example = "1")
    private Long dentisteId;
    @NotEmpty(message = "First name cannot be null or empty")
    @Size(max = 45, message = "First name must be at most 45 characters")
    @Schema(description = "First name of the dentiste", example = "Ousmane")
    private String prenom;
    @NotEmpty(message = "Specialite cannot be null or empty")
    @Size(max = 45, message = "Specialite must be at most 45 characters")
    @Schema(description = "Specialite of the dentiste", example = "Dentiste")
    private String specialite;
    @NotEmpty(message = "Telephone cannot be null or empty")
    @Size(max = 45, message = "Telephone must be at most 45 characters")
    @Schema(description = "Telephone of the dentiste", example = "777777777")
    private String telephone;


}
