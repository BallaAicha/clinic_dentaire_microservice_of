package org.etutoria.equipement.entities;
import jakarta.persistence.*;
import lombok.*;
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "machine")
public class Machine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long machineId;
    private String nom;
    private String description;

}