package co.com.sofka.usecase.ciclista.actualizarciclista;

import co.com.sofka.model.ciclista.Ciclista;
import co.com.sofka.model.ciclista.gateways.CiclistaRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ActualizarCiclistaUseCase {

    private final CiclistaRepository ciclistaRepository;

    public Mono<Ciclista> actualizarCiclista(Ciclista ciclista, String id){
        ciclista.setId(id);
        return ciclistaRepository.save(ciclista);
    }

}
