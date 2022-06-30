package com.example.kafka.consumer;

import com.example.dto.request.TestRequest;
import io.micronaut.configuration.kafka.annotation.KafkaListener;
import io.micronaut.configuration.kafka.annotation.Topic;
import io.micronaut.context.annotation.Property;
import io.micronaut.messaging.Acknowledgement;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@KafkaListener(
        groupId = "group3",
        properties = {
                @Property(name = ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, value = "${kafka.group3.bootstrap.servers}"),
                @Property(name = "security.protocol", value = "${kafka.group3.security.protocol}"),
                @Property(name = "sasl.mechanism", value = "${kafka.group3.sasl.mechanism}"),
                @Property(name = "sasl.jaas.config", value = "${kafka.group3.sasl.jaas.config}")
        }
)
public class Kafka3Listener {
    private static final Logger LOG = LoggerFactory.getLogger(Kafka3Listener.class);

    @Topic("${kafka.group3.topics.test3}")
    public void receive(ConsumerRecord<String, TestRequest> record, Acknowledgement acknowledgement) {
        LOG.info("New Test 3 received");
        LOG.info(record.value().toString());

        acknowledgement.ack();
    }

}
