package co.com.sofka.model.equipo;
import co.com.sofka.model.ciclista.Ciclista;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Equipo {

    private String id;
    private String nombre;
    private String codigo;
    private String pais;

}
