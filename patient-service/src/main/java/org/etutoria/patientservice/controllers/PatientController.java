package org.etutoria.patientservice.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.etutoria.patientservice.dtos.ErrorResponseDto;
import org.etutoria.patientservice.dtos.PatientDto;
import org.etutoria.patientservice.services.IpatientService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(
        name = "CRUD REST APIs for Patients",
        description = "CRUD REST APIs in Patient-app to CREATE, UPDATE, FETCH AND DELETE Patient details"
)
@RestController
@RequestMapping(path = "/api/v1/patients/patient")
@CrossOrigin("*")
@AllArgsConstructor
public class PatientController {
    private final IpatientService ipatientService;

    @Operation(
            summary = "List all Patients REST API",
            description = "REST API to fetch all patients inside Patient-app"
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
    public List<PatientDto> listPatients() {
        return ipatientService.listAllPatients();
    }
}
