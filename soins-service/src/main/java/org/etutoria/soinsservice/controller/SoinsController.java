package org.etutoria.soinsservice.controller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.etutoria.soinsservice.dtos.ErrorResponseDto;
import org.etutoria.soinsservice.dtos.SoinsDto;
import org.etutoria.soinsservice.services.SoinsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "Soins Controller",
        description = "This controller is responsible for handling all the soins related endpoints."
)
@RestController
@RequestMapping(path = "/api/v1/soins/soin")
@CrossOrigin("*")
@AllArgsConstructor
public class SoinsController {
    private final SoinsService soinsService;
    @Operation(
            summary = "List all Soins REST API",
            description = "REST API to fetch all soins inside Soins-app"
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
    public List<SoinsDto> listSoins() {
        return soinsService.listSoins();
    }

    @Operation(
            summary = "Create Soins REST API",
            description = "REST API to create a new Soins inside Soins-app"
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
    public SoinsDto createSoins(@RequestBody SoinsDto soinsDto) {
        return soinsService.createSoins(soinsDto);
    }

    @Operation(
            summary = "Get Soins REST API",
            description = "REST API to fetch a single Soins inside Soins-app"
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
    @GetMapping(path = "{soinsId}")
    public SoinsDto getSoins(@PathVariable Long soinsId) {
        return soinsService.getSoins(soinsId);
    }

}
