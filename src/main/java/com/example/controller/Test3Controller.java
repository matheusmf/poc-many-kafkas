package com.example.controller;

import com.example.dto.request.TestRequest;
import com.example.kafka.producer.Kafka3Client;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.Valid;

@Controller("/test")
public class Test3Controller {
    private static final Logger LOG = LoggerFactory.getLogger(Test3Controller.class);

    private final Kafka3Client kafka3Client;

    public Test3Controller(Kafka3Client kafka3Client) {
        this.kafka3Client = kafka3Client;
    }

    @Post("/send")
    public HttpResponse<?> sendTest(@Valid @Body TestRequest testRequest) {
        kafka3Client.sendTest(testRequest.getTitle(), testRequest);
        return HttpResponse.ok();
    }
}
