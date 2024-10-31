package org.etutoria.rendezvousservice.controller;

import lombok.RequiredArgsConstructor;
import org.etutoria.rendezvousservice.config.TokenService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class TokenController {
    private final TokenService tokenService;

    @PostMapping("/set-token")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void setToken(@RequestHeader("Authorization") String authorizationHeader) {
        String token = authorizationHeader.replace("Bearer ", "");
        tokenService.setToken(token);
    }

    @GetMapping("/get-token")
    public ResponseEntity<String> getToken() {
        String token = tokenService.getToken();
        if (token != null && !token.isEmpty()) {
            return ResponseEntity.ok(token);  // Retourne le token dans la réponse
        } else {
            return ResponseEntity.noContent().build();  // Retourne 204 si le token n'existe pas
        }
    }

}
