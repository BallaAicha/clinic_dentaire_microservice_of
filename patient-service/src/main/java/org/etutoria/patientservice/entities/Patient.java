package org.etutoria.patientservice.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Builder
@Getter
@Setter
@Document
@NoArgsConstructor
public class Patient extends BaseEntity {
    @Id
    private String patientId;
    private Set<Dossier> dossiers = new HashSet<>();
}