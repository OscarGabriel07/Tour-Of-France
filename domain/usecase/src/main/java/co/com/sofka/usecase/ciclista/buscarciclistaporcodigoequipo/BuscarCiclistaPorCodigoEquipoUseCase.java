package co.com.sofka.usecase.ciclista.buscarciclistaporcodigoequipo;

import co.com.sofka.model.ciclista.Ciclista;
import co.com.sofka.model.ciclista.gateways.CiclistaRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class BuscarCiclistaPorCodigoEquipoUseCase {

    private final CiclistaRepository ciclistaRepository;

    public Flux<Ciclista> buscarCiclistaPorCodigoEquipo(String codigoEquipo){
        return ciclistaRepository.findByCodeTeam(codigoEquipo);
    }

}
