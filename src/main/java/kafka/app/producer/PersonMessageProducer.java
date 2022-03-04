package kafka.app.producer;

import io.micronaut.configuration.kafka.annotation.KafkaClient;
import io.micronaut.configuration.kafka.annotation.Topic;
import kafka.app.domain.Person;

@KafkaClient
public interface PersonMessageProducer {

    @Topic("test")
    void sendMessage(Person person);

}