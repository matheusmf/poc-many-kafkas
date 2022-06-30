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
        groupId = "group2",
        properties = {
                @Property(name = ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, value = "${kafka.group2.bootstrap.servers}")
        }
)
public class Kafka2Listener {
    private static final Logger LOG = LoggerFactory.getLogger(Kafka2Listener.class);

    @Topic("${kafka.group2.topics.test2}")
    public void receive(TestRequest testRequest, Acknowledgement acknowledgement) {
        LOG.info("New Test 2 received");
        LOG.info(testRequest.toString());

        acknowledgement.ack();
    }

}
