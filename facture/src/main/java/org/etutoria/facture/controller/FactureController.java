package org.etutoria.facture.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.etutoria.facture.dtos.ErrorResponseDto;
import org.etutoria.facture.dtos.FactureDto;
import org.etutoria.facture.services.IFactureService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(
        name = "Facture Controller",
        description = "This controller is responsible for handling all the facture related endpoints."
)
@RestController
@RequestMapping(path = "/api/v1/factures/bills")
@CrossOrigin("*")
@AllArgsConstructor
public class FactureController {
    private final IFactureService factureService;

    @Operation(
            summary = "List all Factures REST API",
            description = "REST API to fetch all factures inside Facture-app"
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
    public List<FactureDto> listFactures() {
        return factureService.listFactures();
    }


    @Operation(
            summary = "Create Facture REST API",
            description = "REST API to create a new Facture inside Facture-app"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "HTTP Status Created"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "HTTP Status Bad Request",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })

    @PostMapping
    public FactureDto createFacture(@RequestBody FactureDto factureDto) {
        return factureService.createFacture(factureDto);
    }

    @Operation(
            summary = "Get Facture REST API",
            description = "REST API to fetch a facture by its ID inside Facture-app"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "HTTP Status Not Found",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })
    @GetMapping("/{factureId}")
    public FactureDto getFacture(@PathVariable Long factureId) {
        return factureService.getFacture(factureId);
    }
}
