package org.etutoria.facture.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@Table(name = "facture")
public class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "facture_id", nullable = false)
    private Long factureId;

    @Basic
    @Column(name = "montant", nullable = false)
    private Double montant;

    @Basic
    @Column(name = "date_emission", nullable = false)
    private LocalDateTime dateEmission;

}