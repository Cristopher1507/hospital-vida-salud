package pe.cibertec.pacientes_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.cibertec.pacientes_service.entity.Paciente;
import pe.cibertec.pacientes_service.repository.PacienteRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private final PacienteRepository repository;

    public PacienteController(PacienteRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Flux<Paciente> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Paciente> obtenerPorId(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PostMapping
    public Mono<Paciente> registrar(@RequestBody Paciente paciente) {
        return repository.save(paciente);
    }
}