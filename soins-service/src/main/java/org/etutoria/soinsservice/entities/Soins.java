package org.etutoria.soinsservice.entities;

import jakarta.persistence.*;
import lombok.*;


@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "soins")
public class Soins {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "soins_id", nullable = false)
    private Long soinsId;
    @Basic
    @Column(name = "description", nullable = false, length = 255)
    private String description;
    @Basic
    @Column(name = "code", nullable = false, length = 50)
    private String code;
}
