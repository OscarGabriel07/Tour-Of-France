package co.com.sofka.usecase.ciclista.buscarciclistaporcodigoequipo;

import co.com.sofka.model.ciclista.Ciclista;
import co.com.sofka.model.ciclista.gateways.CiclistaRepository;
import co.com.sofka.model.equipo.Equipo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BuscarCiclistaPorCodigoEquipoUseCaseTest {

    @InjectMocks
    BuscarCiclistaPorCodigoEquipoUseCase useCase;

    @Mock
    CiclistaRepository repository;

    @Test
    public void buscarCiclistaPorCodigoEquipo(){

        Equipo equipo1 = new Equipo("e1", "Movistar", "MOV", "España");
        Equipo equipo2 = new Equipo("e2", "Emirates", "UAE", "Emiratos Árabes Unidos");

        Ciclista ciclista1 = new Ciclista("c1", "Matteo Jorgenson", "001", equipo1, "Estadounidense");
        Ciclista ciclista2 = new Ciclista("c2", "Rafael Majka", "002", equipo2, "Estadounidense");
        Ciclista ciclista3 = new Ciclista("c3", "Enric Mas Nicolau", "003", equipo1, "Español");
        Ciclista ciclista4 = new Ciclista("c4", "Brandon Mcnulty", "004", equipo2, "Estadounidense");

        List<Ciclista> ciclistas = List.of(ciclista1, ciclista3);

        when(repository.findByCodeTeam(Mockito.any(String.class))).thenReturn(Flux.fromIterable(ciclistas));

        StepVerifier.create(useCase.buscarCiclistaPorCodigoEquipo("MOV"))
                .expectNext(ciclista1)
                .expectNext(ciclista3)
                .expectComplete()
                .verify();

    }

}