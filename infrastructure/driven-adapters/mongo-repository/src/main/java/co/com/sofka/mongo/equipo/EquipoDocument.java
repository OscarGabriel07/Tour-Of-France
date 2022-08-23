package co.com.sofka.mongo.equipo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EquipoDocument {

    @Id
    private String id;
    private String nombre;
    private String codigo;
    private String pais;

}
