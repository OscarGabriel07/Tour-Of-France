package co.com.sofka.api.equipo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;


@Configuration
public class EquipoRouterRest {
@Bean
public RouterFunction<ServerResponse> routerFunctionEquipo(EquipoHandler equipoHandler) {
    return route(POST("/api/equipo"), equipoHandler::listenPOSTCrearEquipoUseCase)
            .and(route(GET("/api/equipo/listar"), equipoHandler::listenGETListarEquiposUseCase))
            .and(route(GET("/api/equipo/buscar-por-id/{id}"), equipoHandler::listenGETBuscarEquipoPorId))
            .and(route(GET("/api/equipo/buscar-por-pais/{pais}"), equipoHandler::listenGETBuscarEquipoPorPais))
            .and(route(DELETE("/api/equipo/eliminar-por-id/{id}"), equipoHandler::listenDELETEEliminarEquipoPorId))
            .and(route(PUT("/api/equipo/actualizar/{id}"), equipoHandler::listenPUTActualizarEquipo));

    }
}
