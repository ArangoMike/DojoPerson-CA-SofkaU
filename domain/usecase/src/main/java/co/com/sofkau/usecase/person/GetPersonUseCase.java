package co.com.sofkau.usecase.person;


import co.com.sofkau.model.person.Person;
import co.com.sofkau.model.person.gateways.PersonRepository;
import reactor.core.publisher.Mono;

public class GetPersonUseCase {

    private final PersonRepository personRepository;

    public GetPersonUseCase(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Mono<Person> apply(String id){
        /*
        Logic
         */
        return personRepository.getPerson(id)
                .switchIfEmpty(Mono.error(new Exception("Persona no encontrada!")));
    }


}
