package org.etutoria.equipement.entities;

import jakarta.persistence.*;
import lombok.*;


@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "produit")
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long produitId;

    private String nom;

    private String description;
}