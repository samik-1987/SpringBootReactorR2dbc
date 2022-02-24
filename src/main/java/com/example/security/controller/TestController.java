package com.example.security.controller;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
public class TestController {
	
	@GetMapping("/msg")
    public Flux<String> getMsg()
    {
		return Flux.fromIterable(Stream.of("TT", "PP", "RR").collect(Collectors.toList()));
    }

}
