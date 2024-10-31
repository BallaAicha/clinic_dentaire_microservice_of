package org.etutoria.rendezvousservice.entities;

import jakarta.persistence.*;
import lombok.*;
import org.etutoria.rendezvousservice.dentiste.Dentiste;
import org.etutoria.rendezvousservice.patient.Patient;
import org.etutoria.rendezvousservice.produit.Produit;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "rendez_vous")
public class RV {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rv_id", nullable = false)
    private Long rvId;
    @Column(name = "date_heure", nullable = false, length = 50)
    private LocalDateTime dateHeure;
    @Column(name = "duree", nullable = false, length = 50)
    private int duree;
    @Column(name = "dentiste_id", nullable = false)
    private Long dentisteId;
    @Column(name = "dentiste_name", nullable = false)
    private String prenom;
    @Column(name = "dentiste_specialite", nullable = false)
    private String specialite;
    @Column(name = "dentiste_telephone", nullable = false)
    private String telephone;
    @Column(name = "patient_id", nullable = false)
    private String patientId;
    @Column(name = "patient_first_name", nullable = false)
    private String firstName;
    @Column(name = "patient_last_name", nullable = false)
    private String lastName;
    @Column(name = "produit_id", nullable = false)
    private Long produitId;
    @Column(name = "produit_nom", nullable = false)
    private String nom;
    @Column(name = "produit_description", nullable = false)
    private String description;
    @Transient
    private Dentiste dentiste;
//    @OneToMany(mappedBy = "rv")
//    private Set<RV_Soins> rvSoins = new HashSet<>();
    @Transient
    private Patient patient;
    @Transient
    private Set<Produit> produits = new HashSet<>();
}