package pe.cibertec.pacientes_service.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import pe.cibertec.pacientes_service.entity.Paciente;
import reactor.core.publisher.Mono;

public interface PacienteRepository extends ReactiveCrudRepository<Paciente, Long> {

    Mono<Paciente> findByNumeroDocumento(String numeroDocumento);

}