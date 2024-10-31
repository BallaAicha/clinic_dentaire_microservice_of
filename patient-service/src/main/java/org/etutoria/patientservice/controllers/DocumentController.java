package org.etutoria.patientservice.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.etutoria.patientservice.dtos.DossierDto;
import org.etutoria.patientservice.dtos.ErrorResponseDto;
import org.etutoria.patientservice.services.IDossierPatient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Tag(
        name = "CRUD REST APIs for Documents",
        description = "CRUD REST APIs in Document-app to CREATE, UPDATE, FETCH AND DELETE Document details"
)
@RestController
@RequestMapping(path = "/api/v1/patients/documents")
@CrossOrigin("*")
@AllArgsConstructor
public class DocumentController {
    private final IDossierPatient documentService;



    @Operation(
            summary = "List all Documents REST API",
            description = "REST API to fetch all documents inside Document-app"
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
    public List<DossierDto> listDocuments() {
        return documentService.listAllDossiers();
    }
}
