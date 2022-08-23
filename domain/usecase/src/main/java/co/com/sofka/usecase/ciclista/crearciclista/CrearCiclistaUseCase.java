package co.com.sofka.usecase.ciclista.crearciclista;

import co.com.sofka.model.ciclista.Ciclista;
import co.com.sofka.model.ciclista.gateways.CiclistaRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CrearCiclistaUseCase {

    private final CiclistaRepository ciclistaRepository;

    public Mono<Ciclista> crearCiclista(Ciclista ciclista){
        return ciclistaRepository.save(ciclista);
    }

}
