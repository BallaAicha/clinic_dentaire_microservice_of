package org.etutoria.rendezvousservice.soins;

import jakarta.persistence.*;
import lombok.*;


@AllArgsConstructor
@Builder
@Getter
@Setter

@NoArgsConstructor

public class Soins {
    @Id

    private Long soinsId;

    private String description;

    private String code;
}
