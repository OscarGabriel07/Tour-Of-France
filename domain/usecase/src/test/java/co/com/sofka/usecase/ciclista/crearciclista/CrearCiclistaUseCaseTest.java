package co.com.sofka.usecase.ciclista.crearciclista;

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
class CrearCiclistaUseCaseTest {

    @InjectMocks
    CrearCiclistaUseCase useCase;

    @Mock
    CiclistaRepository repository;



    @Test
    public void crearCiclista(){

        Equipo equipo = new Equipo("ideq1", "Groupama", "FDJ", "Francia");
        Ciclista ciclista = new Ciclista("idci1", "Marc Soler", "123", equipo, "Espaniol");

        when(repository.save(Mockito.any(Ciclista.class))).thenReturn(Mono.just(ciclista));

        StepVerifier.create(useCase.crearCiclista(ciclista))
                .expectNext(ciclista)
                .expectComplete()
                .verify();

    }

}