package org.etutoria.equipement.entities;
import jakarta.persistence.*;
import lombok.*;
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "salle")
public class Salle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long salleId;
    private String nom;

}
