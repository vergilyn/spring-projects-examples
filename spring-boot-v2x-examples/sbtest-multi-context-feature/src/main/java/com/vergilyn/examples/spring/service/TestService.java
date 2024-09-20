package com.vergilyn.examples.spring.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Value("${test.username:N/A}")
    private String testUsername;

    public String getTestUsername(){
        return testUsername;
    }

}
