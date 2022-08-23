package co.com.sofka.usecase.ciclista.buscarciclistapornacionalidad;

import co.com.sofka.model.ciclista.Ciclista;
import co.com.sofka.model.ciclista.gateways.CiclistaRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class BuscarCiclistaPorNacionalidadUseCase {

    private final CiclistaRepository ciclistaRepository;

    public Flux<Ciclista> buscarCiclistaPorNacionalidad(String nacionalidad){
        return ciclistaRepository.findByNacionality(nacionalidad);
    }

}
