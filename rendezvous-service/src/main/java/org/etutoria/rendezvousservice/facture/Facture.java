package org.etutoria.rendezvousservice.facture;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@AllArgsConstructor
@Builder
@Getter
@Setter
@NoArgsConstructor

public class Facture {
    @Id
    private Long factureId;

    private Double montant;

    private LocalDateTime dateEmission;

}