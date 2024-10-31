package org.etutoria.rendezvousservice.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.etutoria.rendezvousservice.dentiste.DentisteDto;
import org.etutoria.rendezvousservice.patient.PatientDto;
import org.etutoria.rendezvousservice.produit.ProduitDto;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Schema(name = "Rendez-Vous", description = "Schema to hold Rendez-Vous information")
@Data
public class RVDto {
    @Schema(description = "ID of the Rendez-Vous", example = "1")
    private Long rvId;

    @Schema(description = "Date and time of the Rendez-Vous", example = "2021-12-31T23:59:59")
    @NotEmpty(message = "Date and time cannot be null or empty")
    private LocalDateTime dateHeure;

    @Schema(description = "Duration of the Rendez-Vous", example = "30")
    @NotEmpty(message = "Duration cannot be null or empty")
    private int duree;

    @Schema(description = "Dentist associated with the Rendez-Vous")
    private DentisteDto dentiste;

    @Schema(description = "Patient associated with the Rendez-Vous")
    private PatientDto patient;

    @Schema(description = "Produits associated with the Rendez-Vous")
    private Set<ProduitDto> produits = new HashSet<>();
    private Set<Long> produitIds = new HashSet<>();
    private Long dentisteId;
    private String prenom;
    private String specialite;
    private String telephone;
    private String patientId;
    private String firstName;
    private String lastName;
    private Long produitId;
    private String nom;
    private String description;

}