package com.example.kafka.producer;

import com.example.dto.request.TestRequest;
import io.micronaut.configuration.kafka.annotation.KafkaClient;
import io.micronaut.configuration.kafka.annotation.KafkaKey;
import io.micronaut.configuration.kafka.annotation.Topic;
import io.micronaut.context.annotation.Property;
import org.apache.kafka.clients.producer.ProducerConfig;

@KafkaClient(
        id = "group1",
        acks = KafkaClient.Acknowledge.ALL,
        batch = true,
        properties = {
                @Property(name = ProducerConfig.RETRIES_CONFIG, value = "5"),
                @Property(name = ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, value = "${kafka.group1.bootstrap.servers}")
        }

)
public interface Kafka1Client {

    @Topic("${kafka.group1.topics.test1}")
    void sendTest(@KafkaKey String key, TestRequest testRequest);
}
