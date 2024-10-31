package org.etutoria.patientservice.dtos;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(name = "Patient", description = "Schema to hold Patient information")
@Data
public class PatientDto {
    @Schema(description = "ID of the patient", example = "1")
    private String patientId;


    private String firstName;

    private String lastName;

    private String dateNaissance;


    private String address;


    private String genre;

}
