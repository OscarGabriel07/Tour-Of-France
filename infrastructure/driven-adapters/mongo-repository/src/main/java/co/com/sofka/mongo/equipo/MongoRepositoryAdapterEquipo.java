package co.com.sofka.mongo.equipo;

import co.com.sofka.model.equipo.Equipo;
import co.com.sofka.model.equipo.gateways.EquipoRepository;
import co.com.sofka.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class MongoRepositoryAdapterEquipo extends AdapterOperations<Equipo, EquipoDocument, String, EquipoMongoDBRepository>
implements EquipoRepository
{

    public MongoRepositoryAdapterEquipo(EquipoMongoDBRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Equipo.class));
    }

    @Override
    public Flux<Equipo> findByCountry(String pais) {
        return this.repository.findAll()
                .filter(equipoDocument -> equipoDocument.getPais().equals(pais))
                .map(d -> mapper.map(d, Equipo.class));
    }

}
