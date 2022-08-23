package co.com.sofka.model.ciclista.gateways;

import co.com.sofka.model.ciclista.Ciclista;
import co.com.sofka.model.equipo.Equipo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CiclistaRepository {

    Mono<Ciclista> save(Ciclista ciclista);
    Flux<Ciclista> findAll();
    Mono<Ciclista> findById(String id);
    Flux<Ciclista> findByNacionality(String nacionalidad);
    Mono<Void> deleteById(String id);
}
