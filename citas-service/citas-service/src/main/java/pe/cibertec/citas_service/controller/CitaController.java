package pe.cibertec.citas_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.cibertec.citas_service.RabbitPublisher;
import pe.cibertec.citas_service.entity.Cita;
import pe.cibertec.citas_service.repository.CitaRepository;
import pe.cibertec.citas_service.service.PacienteClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/citas")
public class CitaController {

    private final CitaRepository repository;
    private final PacienteClient pacienteClient;
    private final RabbitPublisher rabbitPublisher;

    public CitaController(CitaRepository repository,
                          PacienteClient pacienteClient,
                          RabbitPublisher rabbitPublisher) {

        this.repository = repository;
        this.pacienteClient = pacienteClient;
        this.rabbitPublisher = rabbitPublisher;
    }

    @GetMapping
    public Flux<Cita> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Mono<Cita> registrar(@RequestBody Cita cita) {

        return pacienteClient.obtenerPaciente(cita.getPacienteId())
                .flatMap(paciente -> {

                    rabbitPublisher.enviar(
                            "Cita registrada para paciente ID: "
                            + cita.getPacienteId());

                    return repository.save(cita);
                });
    }
}