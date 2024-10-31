package org.etutoria.usersservice.entities;
import jakarta.persistence.*;
import lombok.*;
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "dentiste")
public class Dentiste {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dentiste_id", nullable = false)
    private Long dentisteId;
    @Basic
    @Column(name = "prenom", nullable = false, length = 50)
    private String prenom;
    @Basic
    @Column(name = "specialite", nullable = false, length = 50)
    private String specialite;
    @Basic
    @Column(name = "telephone", nullable = false, length = 50)
    private String telephone;
    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    private User user;
    private Long salleId;
    private String nomSalle;


}
