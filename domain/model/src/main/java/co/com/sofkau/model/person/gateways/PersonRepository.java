package co.com.sofkau.model.person.gateways;

import co.com.sofkau.model.person.Person;
import reactor.core.publisher.Mono;

public interface PersonRepository {

    Mono<Person> getPerson(String id);
    Mono<Person> createPerson(Person person);
    Mono<Person> updatePerson(Person person);
    Mono<Void> deletePerson(String id);

}
