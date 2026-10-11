package pe.cibertec.citas_service.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import pe.cibertec.citas_service.entity.Cita;

public interface CitaRepository extends ReactiveCrudRepository<Cita, Long> {

}