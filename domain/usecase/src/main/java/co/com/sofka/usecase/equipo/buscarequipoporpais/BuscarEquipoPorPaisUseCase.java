package co.com.sofka.usecase.equipo.buscarequipoporpais;

import co.com.sofka.model.equipo.Equipo;
import co.com.sofka.model.equipo.gateways.EquipoRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class BuscarEquipoPorPaisUseCase {

    private final EquipoRepository equipoRepository;

    public Flux<Equipo> buscarEquipoPorPais(String pais){
        return equipoRepository.findByCountry(pais);
    }

}
