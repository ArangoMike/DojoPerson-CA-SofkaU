package co.com.sofkau.api;


import co.com.sofkau.model.person.Person;
import co.com.sofkau.usecase.person.CreatePersonUseCase;
import co.com.sofkau.usecase.person.DeletePersonUseCase;
import co.com.sofkau.usecase.person.GetPersonUseCase;
import co.com.sofkau.usecase.person.UpdatePersonUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;


@Configuration
public class RouterRest {

    @Bean
    public RouterFunction<ServerResponse> createPerson(CreatePersonUseCase useCase){

        return route(
                POST("/create/person").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(useCase
                                        .apply(request.bodyToMono(Person.class)),
                                Person.class))
        );
    }

    @Bean
    public RouterFunction<ServerResponse> getPerson(GetPersonUseCase useCase){
        return route(GET("/person/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(useCase.apply(request.pathVariable("id")), Person.class)));
    }

    @Bean
    public RouterFunction<ServerResponse> updatePerson(UpdatePersonUseCase useCase){

        return route(
                POST("/update/person").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(useCase
                                        .apply(request.bodyToMono(Person.class)),
                                Person.class))
        );
    }

    @Bean
    public RouterFunction<ServerResponse> deletePerson(DeletePersonUseCase useCase){

        return route(
                DELETE("/delete/person/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(useCase
                                        .apply(request.pathVariable("id")),
                                Void.class))
        );
    }
}
