package co.com.sofka.usecase.ciclista.listarciclistas;

import co.com.sofka.model.ciclista.Ciclista;
import co.com.sofka.model.ciclista.gateways.CiclistaRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class ListarCiclistasUseCase {

    private final CiclistaRepository ciclistaRepository;

    public Flux<Ciclista> listarCiclistas(){
        return ciclistaRepository.findAll();
    }

}
