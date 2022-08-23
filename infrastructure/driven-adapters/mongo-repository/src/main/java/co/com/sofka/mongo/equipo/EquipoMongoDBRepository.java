package co.com.sofka.mongo.equipo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;

public interface EquipoMongoDBRepository extends ReactiveMongoRepository<EquipoDocument, String>, ReactiveQueryByExampleExecutor<EquipoDocument> {
}
