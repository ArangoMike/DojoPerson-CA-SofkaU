package co.com.sofkau.usecase.person;

import co.com.sofkau.model.person.gateways.PersonRepository;
import reactor.core.publisher.Mono;

public class DeletePersonUseCase {

    private final PersonRepository personRepository;

    public DeletePersonUseCase(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Mono<Void> apply(String id){
        /*
        Logic
         */
        return personRepository.getPerson(id)
                .flatMap(person1 -> personRepository.deletePerson(person1.getId()) );

    }
}
