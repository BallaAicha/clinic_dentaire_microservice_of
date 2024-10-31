package org.etutoria.rendezvousservice.entities;

import jakarta.persistence.*;
import lombok.*;
import org.etutoria.rendezvousservice.facture.Facture;
import org.etutoria.rendezvousservice.soins.Soins;

@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "rv_soins")
public class RV_Soins {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rv_soins_id", nullable = false)
    private Long rvSoinsId;
    @ManyToOne
    @JoinColumn(name = "rv_id", nullable = false)
    private RV rv;
    private Long soinsId;  // Au lieu de Soins
    private Long factureId;  // Au lieu de Facture
}