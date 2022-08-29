package co.com.sofka.usecase.ciclista.actualizarciclista;

import co.com.sofka.model.ciclista.Ciclista;
import co.com.sofka.model.ciclista.gateways.CiclistaRepository;
import co.com.sofka.model.equipo.Equipo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ActualizarCiclistaUseCaseTest {

    @InjectMocks
    ActualizarCiclistaUseCase useCase;

    @Mock
    CiclistaRepository repository;

    @Test
    public void actualizarCiclista(){

        Equipo equipo = new Equipo("ideq1", "Groupama", "FDJ", "Francia");

        Ciclista ciclistaAnterior = new Ciclista("c1", "Ciclista Anterior", "001", equipo, "Espaniol");

        Ciclista ciclistaActual = ciclistaAnterior.
                toBuilder()
                .nombre("Nombre Ciclista modificado")
                .nacionalidad("Frances")
                .build();

        when(repository.save(Mockito.any(Ciclista.class))).thenReturn(Mono.just(ciclistaActual));

        StepVerifier.create(useCase.actualizarCiclista(ciclistaActual, ciclistaAnterior.getId()))
                .expectNextMatches(ciclista -> ciclista.getNacionalidad().equals("Frances"))
                .expectComplete()
                .verify();

    }
}