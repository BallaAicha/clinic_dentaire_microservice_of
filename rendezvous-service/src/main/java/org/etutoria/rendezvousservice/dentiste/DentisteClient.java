package org.etutoria.rendezvousservice.dentiste;

import lombok.RequiredArgsConstructor;
import org.etutoria.rendezvousservice.config.TokenService;
import org.etutoria.rendezvousservice.exception.BusinessException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DentisteClient {
    @Value("${application.config.dentist-url}")
    private String dentistUrl;
    private final RestTemplate restTemplate;
    private final TokenService tokenService;

    public List<DentisteDto> getDentistes() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + tokenService.getToken());
        HttpEntity<?> requestEntity = new HttpEntity<>(headers);
        ParameterizedTypeReference<List<DentisteDto>> responseType = new ParameterizedTypeReference<>() {};
        ResponseEntity<List<DentisteDto>> responseEntity =
                restTemplate.exchange(
                        dentistUrl,
                        HttpMethod.GET,
                        requestEntity,
                        responseType);
        if (responseEntity.getStatusCode().isError()) {
            throw new BusinessException("An error occurred while fetching the dentists: " + responseEntity.getStatusCode());
        }
        return responseEntity.getBody();
    }
}