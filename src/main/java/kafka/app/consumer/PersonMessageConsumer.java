package kafka.app.consumer;

import io.micronaut.configuration.kafka.annotation.KafkaListener;
import io.micronaut.configuration.kafka.annotation.OffsetReset;
import io.micronaut.configuration.kafka.annotation.Topic;
import kafka.app.domain.Person;

@KafkaListener(offsetReset = OffsetReset.EARLIEST, clientId = "client-test", groupId = "group-test")
public class PersonMessageConsumer {

    @Topic("test")
    public void listen(Person person){
        System.out.println("The person is: " + person.getName());
    }

}