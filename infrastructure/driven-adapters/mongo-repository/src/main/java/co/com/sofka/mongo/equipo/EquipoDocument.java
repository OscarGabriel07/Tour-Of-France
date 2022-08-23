package co.com.sofka.mongo.equipo;

import co.com.sofka.model.ciclista.Ciclista;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EquipoDocument {

    @Id
    private String id;
    private String nombre;
    private String codigo;
    private String pais;

}
