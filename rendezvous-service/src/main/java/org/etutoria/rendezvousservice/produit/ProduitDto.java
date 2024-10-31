package org.etutoria.rendezvousservice.produit;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(name = "Produit", description = "Schema to hold Produit information")
@Data
public class ProduitDto {
    @Schema(description = "ID of the produit", example = "1")
    private Long produitId;

    @Schema(description = "Nom of the produit", example = "Produit 1")
    @Size(max = 45, message = "Nom must be at most 45 characters")
    @NotEmpty(message = "Nom cannot be null or empty")
    private String nom;

    @Schema(description = "Description of the produit", example = "Produit 1")
    @Size(max = 45, message = "Description must be at most 45 characters")
    @NotEmpty(message = "Description cannot be null or empty")
    private String description;


}
