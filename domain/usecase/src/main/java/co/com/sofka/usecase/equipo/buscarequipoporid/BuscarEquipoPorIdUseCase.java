package co.com.sofka.usecase.equipo.buscarequipoporid;

import co.com.sofka.model.equipo.Equipo;
import co.com.sofka.model.equipo.gateways.EquipoRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class BuscarEquipoPorIdUseCase {

    private final EquipoRepository equipoRepository;

    public Mono<Equipo> buscarEquipoPorId(String id){
        return equipoRepository.findById(id);
    }

}
