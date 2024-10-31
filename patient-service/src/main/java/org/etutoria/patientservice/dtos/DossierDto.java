package org.etutoria.patientservice.dtos;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.etutoria.patientservice.entities.TypeFiche;


@Schema(name = "Dossier", description = "Schema to hold Dossier information")
@Data
public class DossierDto {
    @Schema(description = "ID of the dossier", example = "1")
    private String id;
    @NotEmpty(message = "Type of fiche cannot be null or empty")
    @Schema(description = "Type of fiche", example = "TYPE1")
    private TypeFiche typeFiche;
    @Schema(description = "Patient associated with the dossier")
    private PatientDto patient;


}
