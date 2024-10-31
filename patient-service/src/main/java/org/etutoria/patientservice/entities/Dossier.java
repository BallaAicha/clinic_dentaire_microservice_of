package org.etutoria.patientservice.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;

@AllArgsConstructor
@Builder
@Getter
@Setter
@Validated
@NoArgsConstructor
@Document
public class Dossier {
    @Id
    private String id;
    private TypeFiche typeFiche;
    @DBRef
    private Patient patient;
}