package co.com.sofkau.usecase.person;

import co.com.sofkau.model.person.Person;
import co.com.sofkau.model.person.gateways.PersonRepository;
import reactor.core.publisher.Mono;

public class UpdatePersonUseCase {

    private final PersonRepository personRepository;

    public UpdatePersonUseCase(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Mono<Person> apply(Mono<Person> person){
        /*
        Logic
         */
        return person
                .flatMap(person1 -> personRepository.updatePerson(person1) )
                .switchIfEmpty(Mono.error(new Exception("Persona no encontrada!")));
    }
}
