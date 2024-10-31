package org.etutoria.rendezvousservice.patient;

import lombok.*;
import org.springframework.data.annotation.Id;


@AllArgsConstructor
@Builder
@Getter
@Setter
@NoArgsConstructor
public class Patient {
    @Id
    private String patientId;
    // Ajoutez le getter pour firstName
    @Getter
    private String firstName;
    @Getter
    private String lastName;
    @Getter
    private String dateNaissance;
    @Getter
    private String address;
    @Getter
    private String genre;


}