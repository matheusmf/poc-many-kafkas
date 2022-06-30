package com.example.controller;

import com.example.dto.request.TestRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import com.example.kafka.producer.Kafka2Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.Valid;

@Controller("/test2")
public class Test2Controller {

    private static final Logger LOG = LoggerFactory.getLogger(Test2Controller.class);

    private final Kafka2Client kafka2Client;

    public Test2Controller(Kafka2Client kafka2Client) {
        this.kafka2Client = kafka2Client;
    }

    @Post("/send")
    public HttpResponse<?> sendTest(@Valid @Body TestRequest testRequest) {
        kafka2Client.sendTest(testRequest.getTitle(), testRequest);
        return HttpResponse.ok();
    }

}
