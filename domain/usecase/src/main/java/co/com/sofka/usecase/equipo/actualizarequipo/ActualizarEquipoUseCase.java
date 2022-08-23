package co.com.sofka.usecase.equipo.actualizarequipo;

import co.com.sofka.model.equipo.Equipo;
import co.com.sofka.model.equipo.gateways.EquipoRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ActualizarEquipoUseCase {

    private final EquipoRepository equipoRepository;

    public Mono<Equipo> actualizarEquipo(Equipo equipo, String id){
        equipo.setId(id);
        return equipoRepository.save(equipo);
    }

}
