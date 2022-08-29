package co.com.sofka.usecase.ciclista.buscarciclistaporid;

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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BuscarCiclistaPorIdUseCaseTest {

    @InjectMocks
    BuscarCiclistaPorIdUseCase useCase;

    @Mock
    CiclistaRepository repository;

    @Test
    public void buscarCiclistaPorId(){

        Equipo equipo1 = new Equipo("e1", "Movistar", "MOV", "España");
        Ciclista ciclista = new Ciclista("c1", "Enric Mas Nicolau", "003", equipo1, "Español");

        when(repository.findById(Mockito.any(String.class))).thenReturn(Mono.just(ciclista));

        StepVerifier.create(useCase.buscarCiclistaPorId("c1"))
                .expectNext(ciclista)
                .expectComplete()
                .verify();

    }


}