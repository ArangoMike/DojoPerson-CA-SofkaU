package co.com.sofkau.mongo;

import co.com.sofkau.mongo.data.PersonDTO;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;

public interface MongoDBRepository extends ReactiveMongoRepository<PersonDTO, String>, ReactiveQueryByExampleExecutor<PersonDTO> {
}
