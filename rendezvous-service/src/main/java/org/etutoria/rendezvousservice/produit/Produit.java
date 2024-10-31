package org.etutoria.rendezvousservice.produit;
import jakarta.persistence.*;
import lombok.*;
@AllArgsConstructor
@Builder
@Getter
@Setter
@NoArgsConstructor
public class Produit {
    @Id
    private Long produitId;

    private String nom;

    private String description;
}