package org.etutoria.equipement.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

import org.etutoria.equipement.dtos.ErrorResponseDto;
import org.etutoria.equipement.dtos.ProduitDto;
import org.etutoria.equipement.services.IProduitService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Tag(
        name = "Product Controller",
        description = " This controller is responsible for managing products."
)
@RestController
@RequestMapping(path = "/api/v1/equipments/produits")
@CrossOrigin("*")
@AllArgsConstructor
public class ProduitController {
    private final IProduitService produitService;
    @Operation(
            summary = "List all Products REST API",
            description = "REST API to fetch all products inside Product-app"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })
    @GetMapping
    public List<ProduitDto> listProduits() {
        return produitService.getProduits();
    }
}
