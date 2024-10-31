package org.etutoria.equipement.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

import org.etutoria.equipement.dtos.ErrorResponseDto;
import org.etutoria.equipement.dtos.MachineDto;
import org.etutoria.equipement.services.IMachineService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Tag(
        name = "Machine Controller",
        description = "This controller is responsible for handling all the machine related endpoints."
)
@RestController
@RequestMapping(path = "/api/v1/equipments/machines")
@CrossOrigin("*")
@AllArgsConstructor
public class MachineController {
    private final IMachineService machineService;
    @Operation(
            summary = "List all Machines REST API",
            description = "REST API to fetch all machines inside Machine-app"
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
    public List<MachineDto> listMachines() {
        return machineService.listMachines();
    }
}
