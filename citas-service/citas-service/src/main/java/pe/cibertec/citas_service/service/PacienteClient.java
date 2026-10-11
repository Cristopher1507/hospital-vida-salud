package pe.cibertec.citas_service.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Service
public class PacienteClient {

    private final WebClient webClient;

    public PacienteClient() {
        this.webClient = WebClient.builder()
                .baseUrl("http://localhost:8081")
                .build();
    }

    public Mono<String> obtenerPaciente(Long id) {
        return webClient.get()
                .uri("/pacientes/" + id)
                .retrieve()
                .bodyToMono(String.class);
    }
}