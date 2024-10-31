package org.etutoria.rendezvousservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.etutoria.rendezvousservice.dtos.ErrorResponseDto;
import org.etutoria.rendezvousservice.dtos.RVDto;
import org.etutoria.rendezvousservice.services.IRVService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rendezvous/rendezvous")
@RequiredArgsConstructor
public class RVController {
    private final IRVService rvService;
    @Operation(
            summary = "List All RVs REST API",
            description = "REST API to list all RVs with pagination inside RV-app"
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
    public List<RVDto> listAllRVs() {
        List<RVDto> rvList = rvService.listAllRVs();
        return rvList;
    }


    @PostMapping
    public ResponseEntity<RVDto> createRV(@RequestBody RVDto rvDto) {
        RVDto createdRV = rvService.createRV(rvDto);
        return new ResponseEntity<>(createdRV, HttpStatus.CREATED);
    }
}