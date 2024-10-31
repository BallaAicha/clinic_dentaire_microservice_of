package org.etutoria.usersservice.salle;
import jakarta.persistence.*;
import lombok.*;
@AllArgsConstructor
@Builder
@Getter
@Setter
@NoArgsConstructor
public class Salle {
    @Id
    private Long salleId;
    private String nom;

}
