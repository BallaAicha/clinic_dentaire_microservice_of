package org.etutoria.usersservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.etutoria.usersservice.dtos.DentisteDto;
import org.etutoria.usersservice.dtos.ErrorResponseDto;
import org.etutoria.usersservice.services.IDentisteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "Dentiste Controller",
        description = "This controller is responsible for handling all the dentiste related endpoints."
)
@RestController
@RequestMapping("/api/v1/users/dentistes")
@AllArgsConstructor
public class DentisteController {

    private final IDentisteService dentisteService;
    @Operation(
            summary = "Create Dentiste REST API",
            description = "REST API to create a new dentiste inside Dentiste-app"
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
    @PostMapping
    public ResponseEntity<DentisteDto> createDentiste(@RequestBody DentisteDto dentisteDto) {
        DentisteDto createdDentiste = dentisteService.createDentiste(dentisteDto);
        return new ResponseEntity<>(createdDentiste, HttpStatus.CREATED);
    }
    @Operation(
            summary = "Get All Dentistes REST API",
            description = "REST API to get all the dentistes inside Dentiste-app"
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
            )
    })
    @GetMapping
    public ResponseEntity<List<DentisteDto>> getAllDentistes() {
        return new ResponseEntity<>(dentisteService.getAllDentistes(), HttpStatus.OK);
    }
}