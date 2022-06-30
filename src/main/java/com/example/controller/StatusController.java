package com.example.controller;

import io.micronaut.http.annotation.Controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Get;

@Controller
public class StatusController {

    @Get("/status")
    public HttpResponse<?> status() {
        return HttpResponse.ok("POC MANY KAFKAS APP");
    }
}
