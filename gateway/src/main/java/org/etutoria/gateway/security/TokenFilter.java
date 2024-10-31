package org.etutoria.gateway.security;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.RequestEntity;
import org.springframework.web.client.RestTemplate;

@Component
public class TokenFilter extends AbstractGatewayFilterFactory<TokenFilter.Config> {

    @Value("${application.config.token-url}")
    private String tokenUrl;
    private final RestTemplate restTemplate;

    public TokenFilter(RestTemplate restTemplate) {
        super(Config.class);
        this.restTemplate = restTemplate;
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            String authorizationHeader = exchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
            if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
                RequestEntity<Void> requestEntity = RequestEntity
                        .post(tokenUrl)
                        .header(HttpHeaders.AUTHORIZATION, authorizationHeader)
                        .build();
                restTemplate.exchange(requestEntity, Void.class);
            }
            return chain.filter(exchange);
        };
    }

    public static class Config {
        // Configuration properties if needed
    }
}