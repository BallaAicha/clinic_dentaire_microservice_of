package org.etutoria.patientservice.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BaseEntity {
    private String firstName;
    private String lastName;
    private String dateNaissance;
    private String address;
    private String genre;
}