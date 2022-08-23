package co.com.sofka.mongo.ciclista;

import co.com.sofka.mongo.equipo.EquipoDocument;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;

public interface CiclistaMongoDBRepository extends ReactiveMongoRepository<CiclistaDocument, String>, ReactiveQueryByExampleExecutor<CiclistaDocument> {
}
