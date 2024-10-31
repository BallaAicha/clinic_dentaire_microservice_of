package org.etutoria.rendezvousservice.dentiste;
import lombok.*;

@AllArgsConstructor
@Builder
@Getter
@Setter
@NoArgsConstructor

public class Dentiste {
    private Long dentisteId;
    private String prenom;
    private String specialite;
    private String telephone;
    private Long salleId;
    private String nomSalle;


}
