package co.com.sofka.api.ciclista;

import co.com.sofka.api.ciclista.CiclistaHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;


@Configuration
public class CiclistaRouterRest {
@Bean
public RouterFunction<ServerResponse> routerFunction(CiclistaHandler ciclistaHandler) {
    return route(PUT("/api/ciclista/actualizar/{id}"), ciclistaHandler::listenPUTActualizarCiclista)
            .and(route(GET("/api/ciclista/buscar-por-id/{id}"), ciclistaHandler::listenGETBuscarCiclistaPorId))
            .and(route(GET("/api/ciclista/buscar-por-nacionalidad/{nacionalidad}"), ciclistaHandler::listenGETBuscarCiclistaPorNacionalidad))
            .and(route(POST("/api/ciclista"), ciclistaHandler::listenPOSTCrearCiclistaUseCase))
            .and(route(DELETE("/api/ciclista/eliminar-por-id/{id}"), ciclistaHandler::listenDELETEEliminarEquipoPorId))
            .and(route(GET("/api/ciclista/listar"), ciclistaHandler::listenGETListarCiclistasUseCase));

    }
}
