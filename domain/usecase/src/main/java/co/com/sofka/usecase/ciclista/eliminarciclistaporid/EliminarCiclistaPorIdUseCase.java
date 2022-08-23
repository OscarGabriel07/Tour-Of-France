package co.com.sofka.usecase.ciclista.eliminarciclistaporid;

import co.com.sofka.model.ciclista.gateways.CiclistaRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class EliminarCiclistaPorIdUseCase {

    private final CiclistaRepository ciclistaRepository;

    public Mono<Void> eliminarCiclistaPorId(String id){
        return ciclistaRepository.deleteById(id);
    }

}
