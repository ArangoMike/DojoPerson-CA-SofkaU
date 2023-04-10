package co.com.sofkau.usecase.person;

import co.com.sofkau.model.person.Person;
import co.com.sofkau.model.person.gateways.PersonRepository;
import reactor.core.publisher.Mono;

public class CreatePersonUseCase {

    private final PersonRepository personRepository;


    public CreatePersonUseCase(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Mono<Person> apply(Mono<Person> person){
        /*
        Logic
         */
        return person
                .flatMap(person1 -> personRepository.createPerson(person1) );
    }
}
