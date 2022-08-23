package co.com.sofka.usecase.ciclista.buscarciclistaporid;

import co.com.sofka.model.ciclista.Ciclista;
import co.com.sofka.model.ciclista.gateways.CiclistaRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class BuscarCiclistaPorIdUseCase {

    private final CiclistaRepository ciclistaRepository;

    public Mono<Ciclista> buscarCiclistaPorId(String id){
        return ciclistaRepository.findById(id);
    }

}
