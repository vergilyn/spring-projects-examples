package com.vergilyn.examples.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;

@RestController
@RequestMapping
public class HelloController {

    @GetMapping("/hello")
    public String hello(String name){
        return "Hello " + name + ": " + LocalTime.now();
    }
}
