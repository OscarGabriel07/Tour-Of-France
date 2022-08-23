package co.com.sofka.usecase.equipo.listarequipos;

import co.com.sofka.model.equipo.Equipo;
import co.com.sofka.model.equipo.gateways.EquipoRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class ListarEquiposUseCase {

    private final EquipoRepository equipoRepository;

    public Flux<Equipo> listarEquipos(){
        return equipoRepository.findAll();
    }

}
