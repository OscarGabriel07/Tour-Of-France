package co.com.sofka.usecase.equipo.eliminarequipoporid;

import co.com.sofka.model.equipo.gateways.EquipoRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class EliminarEquipoPorIdUseCase {

    private final EquipoRepository equipoRepository;

    public Mono<Void> eliminarEquipoPorId(String id){
        return equipoRepository.deleteById(id);
    }

}
