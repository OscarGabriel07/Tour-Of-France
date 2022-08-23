package co.com.sofka.model.equipo.gateways;

import co.com.sofka.model.equipo.Equipo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EquipoRepository {

    Mono<Equipo> save(Equipo equipo);
    Flux<Equipo> findAll();
    Mono<Equipo> findById(String id);
    Flux<Equipo> findByCountry(String pais);
    Mono<Void> deleteById(String id);

}
