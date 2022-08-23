package co.com.sofka.api.equipo;

import co.com.sofka.model.equipo.Equipo;
import co.com.sofka.usecase.equipo.actualizarequipo.ActualizarEquipoUseCase;
import co.com.sofka.usecase.equipo.buscarequipoporid.BuscarEquipoPorIdUseCase;
import co.com.sofka.usecase.equipo.buscarequipoporpais.BuscarEquipoPorPaisUseCase;
import co.com.sofka.usecase.equipo.crearequipo.CrearEquipoUseCase;
import co.com.sofka.usecase.equipo.eliminarequipoporid.EliminarEquipoPorIdUseCase;
import co.com.sofka.usecase.equipo.listarequipos.ListarEquiposUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class EquipoHandler {

    private final CrearEquipoUseCase crearEquipoUseCase;
    private final ListarEquiposUseCase listarEquiposUseCase;
    private final BuscarEquipoPorIdUseCase buscarEquipoPorIdUseCase;
    private final BuscarEquipoPorPaisUseCase buscarEquipoPorPaisUseCase;
    private final EliminarEquipoPorIdUseCase eliminarEquipoPorIdUseCase;
    private final ActualizarEquipoUseCase actualizarEquipoUseCase;

    public Mono<ServerResponse> listenPOSTCrearEquipoUseCase(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(Equipo.class)
                .flatMap(elemento -> ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                        .body(crearEquipoUseCase.crearEquipo(elemento), Equipo.class));
    }

    public Mono<ServerResponse> listenGETListarEquiposUseCase(ServerRequest serverRequest){
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(listarEquiposUseCase.listarEquipos(), Equipo.class);
    }

    public Mono<ServerResponse> listenGETBuscarEquipoPorId(ServerRequest serverRequest){
        var equipoId= serverRequest.pathVariable("id");
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(buscarEquipoPorIdUseCase.buscarEquipoPorId(equipoId), Equipo.class);
    }

    public Mono<ServerResponse> listenGETBuscarEquipoPorPais(ServerRequest serverRequest){
        var paisEquipo = serverRequest.pathVariable("pais");
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(buscarEquipoPorPaisUseCase.buscarEquipoPorPais(paisEquipo), Equipo.class);
    }

    public Mono<ServerResponse> listenDELETEEliminarEquipoPorId(ServerRequest serverRequest){
        var equipoId= serverRequest.pathVariable("id");
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(eliminarEquipoPorIdUseCase.eliminarEquipoPorId(equipoId), Equipo.class);
    }

    public Mono<ServerResponse> listenPUTActualizarEquipo(ServerRequest serverRequest){
        var equipoId= serverRequest.pathVariable("id");
        return serverRequest.bodyToMono(Equipo.class)
                .flatMap(equipo -> actualizarEquipoUseCase.actualizarEquipo(equipo, equipoId))
                .flatMap(result -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(result));
    }

}

