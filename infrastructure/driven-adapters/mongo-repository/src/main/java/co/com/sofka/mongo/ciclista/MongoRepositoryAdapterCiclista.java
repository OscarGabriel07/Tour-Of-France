package co.com.sofka.mongo.ciclista;

import co.com.sofka.model.ciclista.Ciclista;
import co.com.sofka.model.ciclista.gateways.CiclistaRepository;
import co.com.sofka.model.equipo.Equipo;
import co.com.sofka.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public class MongoRepositoryAdapterCiclista extends AdapterOperations<Ciclista, CiclistaDocument, String, CiclistaMongoDBRepository>
implements CiclistaRepository
{

    public MongoRepositoryAdapterCiclista(CiclistaMongoDBRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Ciclista.class));
    }

    @Override
    public Flux<Ciclista> findByNacionality(String nacionalidad) {
        return this.repository.findAll()
                .filter(ciclistaDocument -> ciclistaDocument.getNacionalidad().equals(nacionalidad))
                .map(d -> mapper.map(d, Ciclista.class));
    }

    @Override
    public Flux<Ciclista> findByCodeTeam(String codigoEquipo) {
        return this.repository.findAll()
                .filter(ciclistaDocument -> ciclistaDocument.getEquipo().getCodigo().equals(codigoEquipo))
                .map(d -> mapper.map(d, Ciclista.class));
    }


}
