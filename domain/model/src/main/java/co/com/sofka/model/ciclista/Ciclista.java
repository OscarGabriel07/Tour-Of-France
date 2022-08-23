package co.com.sofka.model.ciclista;
import co.com.sofka.model.equipo.Equipo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Ciclista {

    private String id;
    private String nombre;
    private String numeroCompetidor;
    private Equipo equipo;
    private String nacionalidad;
}
