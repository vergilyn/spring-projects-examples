package com.vergilyn.examples.spring.boot.v2x.async.service;

import com.vergilyn.examples.spring.boot.v2x.async.AsyncFeaturesApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest(classes = AsyncFeaturesApplication.class)
class AsyncServiceTest {
    @Autowired
    private AsyncService asyncService;

    @Test
    void executeAsync() {
        LocalDateTime localDateTime = asyncService.executeAsync(1000);
        System.out.println(localDateTime);
    }
}