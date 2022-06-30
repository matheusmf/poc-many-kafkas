package com.example.kafka.producer;

import com.example.dto.request.TestRequest;
import io.micronaut.configuration.kafka.annotation.KafkaClient;
import io.micronaut.configuration.kafka.annotation.KafkaKey;
import io.micronaut.configuration.kafka.annotation.Topic;
import io.micronaut.context.annotation.Property;
import org.apache.kafka.clients.producer.ProducerConfig;

@KafkaClient(
        id = "group3",
        acks = KafkaClient.Acknowledge.ALL,
        properties = {
                @Property(name = ProducerConfig.RETRIES_CONFIG, value = "5"),
                @Property(name = ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, value = "${kafka.group3.bootstrap.servers}"),
                @Property(name = "security.protocol", value = "${kafka.group3.security.protocol}"),
                @Property(name = "sasl.mechanism", value = "${kafka.group3.sasl.mechanism}"),
                @Property(name = "sasl.jaas.config", value = "${kafka.group3.sasl.jaas.config}")
        }
)
public interface Kafka3Client {

    @Topic("${kafka.group3.topics.test3}")
    void sendTest(@KafkaKey String key, TestRequest testRequest);
}
