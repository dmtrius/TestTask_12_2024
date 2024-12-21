package pl.dmt.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class LogServiceImpl implements LogService {
    @Value("${app.log-service.url}")
    private String baseUrl;
    private final WebClient webClient;

    public LogServiceImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder
                .baseUrl(baseUrl)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    public void logMessage(String message) {
        try {
            var response = webClient.post()
                .uri(baseUrl)
                .body(Mono.just(message), String.class)
                .retrieve()
                .toEntity(String.class)
                .block();
            log.info("LOGGED> message: {} with response: {}", message, response);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
