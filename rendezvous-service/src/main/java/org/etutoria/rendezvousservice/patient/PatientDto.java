package org.etutoria.rendezvousservice.patient;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(name = "Patient", description = "Schema to hold Patient information")
@Data
public class PatientDto {
    @Schema(description = "ID of the patient", example = "1")
    private String patientId;

    @Schema(description = "First name of the patient", example = "Ousmane")
    private String firstName;

    @Schema(description = "Last name of the patient", example = "Diallo")
    private String lastName;

    @Schema(description = "Date of birth of the patient", example = "1990-01-01")
    private String dateNaissance;

    @Schema(description = "Address of the patient", example = "123 Main St")
    private String address;

    @Schema(description = "Gender of the patient", example = "Male")
    private String genre;

}
