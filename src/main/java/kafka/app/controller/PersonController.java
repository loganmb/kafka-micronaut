package kafka.app.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import jakarta.inject.Inject;
import kafka.app.domain.Person;
import kafka.app.producer.PersonMessageProducer;

@Controller("/person")
public class PersonController {

    @Inject
    ObjectMapper mapper;

    @Inject
    PersonMessageProducer producer;

    @Post(value = "/", produces = MediaType.TEXT_JSON)
    public HttpResponse createPerson(@Body Person payload){

        try {
//            Person person = mapper.convertValue(payload, Person.class);
            Person person = payload;

            producer.sendMessage(person);

            return HttpResponse.created(person);

        }catch(Exception e){

            return HttpResponse.serverError();

        }

    }

}
