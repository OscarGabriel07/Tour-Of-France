package co.com.sofka.api.ciclista;

import co.com.sofka.model.ciclista.Ciclista;
import co.com.sofka.model.equipo.Equipo;
import co.com.sofka.usecase.ciclista.actualizarciclista.ActualizarCiclistaUseCase;
import co.com.sofka.usecase.ciclista.buscarciclistaporid.BuscarCiclistaPorIdUseCase;
import co.com.sofka.usecase.ciclista.buscarciclistapornacionalidad.BuscarCiclistaPorNacionalidadUseCase;
import co.com.sofka.usecase.ciclista.crearciclista.CrearCiclistaUseCase;
import co.com.sofka.usecase.ciclista.eliminarciclistaporid.EliminarCiclistaPorIdUseCase;
import co.com.sofka.usecase.ciclista.listarciclistas.ListarCiclistasUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class CiclistaHandler {

    private final ActualizarCiclistaUseCase actualizarCiclistaUseCase;
    private final BuscarCiclistaPorIdUseCase buscarCiclistaPorIdUseCase;
    private final BuscarCiclistaPorNacionalidadUseCase buscarCiclistaPorNacionalidadUseCase;
    private final CrearCiclistaUseCase crearCiclistaUseCase;
    private final EliminarCiclistaPorIdUseCase eliminarCiclistaPorIdUseCase;
    private final ListarCiclistasUseCase listarCiclistasUseCase;

    public Mono<ServerResponse> listenPUTActualizarCiclista(ServerRequest serverRequest){
        var ciclistaId= serverRequest.pathVariable("id");
        return serverRequest.bodyToMono(Ciclista.class)
                .flatMap(ciclista -> actualizarCiclistaUseCase.actualizarCiclista(ciclista, ciclistaId))
                .flatMap(result -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(result));
    }

    public Mono<ServerResponse> listenGETBuscarCiclistaPorId(ServerRequest serverRequest){
        var ciclistaId= serverRequest.pathVariable("id");
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(buscarCiclistaPorIdUseCase.buscarCiclistaPorId(ciclistaId), Ciclista.class);
    }

    public Mono<ServerResponse> listenGETBuscarCiclistaPorNacionalidad(ServerRequest serverRequest){
        var nacionalidadCiclista = serverRequest.pathVariable("nacionalidad");
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(buscarCiclistaPorNacionalidadUseCase.buscarCiclistaPorNacionalidad(nacionalidadCiclista), Ciclista.class);
    }

    public Mono<ServerResponse> listenPOSTCrearCiclistaUseCase(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(Ciclista.class)
                .flatMap(elemento -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(crearCiclistaUseCase.crearCiclista(elemento), Ciclista.class));
    }

    public Mono<ServerResponse> listenDELETEEliminarEquipoPorId(ServerRequest serverRequest){
        var ciclistaId= serverRequest.pathVariable("id");
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(eliminarCiclistaPorIdUseCase.eliminarCiclistaPorId(ciclistaId), Ciclista.class);
    }

    public Mono<ServerResponse> listenGETListarCiclistasUseCase(ServerRequest serverRequest){
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(listarCiclistasUseCase.listarCiclistas(), Ciclista.class);
    }
}
