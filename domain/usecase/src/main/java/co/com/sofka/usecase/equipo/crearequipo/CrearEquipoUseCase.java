package co.com.sofka.usecase.equipo.crearequipo;

import co.com.sofka.model.equipo.Equipo;
import co.com.sofka.model.equipo.gateways.EquipoRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CrearEquipoUseCase {

    private final EquipoRepository equipoRepository;

    public Mono<Equipo> crearEquipo(Equipo equipo){
        return equipoRepository.save(equipo);
    }
}
