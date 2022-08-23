package co.com.sofka.model.equipo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


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
