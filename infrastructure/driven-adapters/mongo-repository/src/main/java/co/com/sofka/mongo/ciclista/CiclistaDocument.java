package co.com.sofka.mongo.ciclista;

import co.com.sofka.model.ciclista.Ciclista;
import co.com.sofka.model.equipo.Equipo;
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
public class CiclistaDocument {

    @Id
    private String id;
    private String nombre;
    private String numeroCompetidor;
    private Equipo equipo;
    private String nacionalidad;

}
