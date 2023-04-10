package co.com.sofkau.mongo;


import co.com.sofkau.model.person.Person;
import co.com.sofkau.model.person.gateways.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
public class PersonRepositoryImpl implements PersonRepository {

    private MongoRepositoryAdapter repositoryAdapter;
    @Override
    public Mono<Person> getPerson(String id) {
        return repositoryAdapter.findById(id);
    }

    @Override
    public Mono<Person> createPerson(Person person) {
        return repositoryAdapter.save(person);
    }

    @Override
    public Mono<Person> updatePerson(Person person) {
        return repositoryAdapter.save(person);
    }

    @Override
    public Mono<Void> deletePerson(String id) {
        return repositoryAdapter.deleteById(id);
    }
}
