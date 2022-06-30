package com.example.controller;

import com.example.dto.request.TestRequest;
import com.example.kafka.producer.Kafka1Client;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.Valid;

@Controller("/test")
public class Test1Controller {

    private static final Logger LOG = LoggerFactory.getLogger(Test1Controller.class);

    private final Kafka1Client kafka1Client;

    public Test1Controller(Kafka1Client kafka1Client) {
        this.kafka1Client = kafka1Client;
    }

    @Post("/send")
    public HttpResponse<?> sendTest(@Valid @Body TestRequest testRequest) {
        kafka1Client.sendTest(testRequest.getTitle(), testRequest);
        return HttpResponse.ok();
    }

}
