package co.com.sofka.usecase.ciclista.crearciclista;

import co.com.sofka.model.ciclista.Ciclista;
import co.com.sofka.model.ciclista.gateways.CiclistaRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.stream.Collectors;

@RequiredArgsConstructor
public class CrearCiclistaUseCase {

    private final CiclistaRepository ciclistaRepository;

    public Mono<Ciclista> crearCiclista(Ciclista ciclista){

        if(ciclista.getNumeroCompetidor().matches("[0-9]{1,3}")){
            return ciclistaRepository.save(ciclista);
        }

        return null;
    }

}
