package com.example.kafka.consumer;

import com.example.dto.request.TestRequest;
import io.micronaut.configuration.kafka.annotation.KafkaListener;
import io.micronaut.configuration.kafka.annotation.Topic;
import io.micronaut.context.annotation.Property;
import io.micronaut.messaging.Acknowledgement;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@KafkaListener(
        groupId = "group1",
        properties = {
                @Property(name = ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, value = "${kafka.group1.bootstrap.servers}")
        }
)
public class Kafka1Listener {
    private static final Logger LOG = LoggerFactory.getLogger(Kafka1Listener.class);

    @Topic("${kafka.group1.topics.test1}")
    public void receive(TestRequest testRequest, Acknowledgement acknowledgement) {
        LOG.info("New Test  1received");
        LOG.info(testRequest.toString());

        acknowledgement.ack();
    }

}
