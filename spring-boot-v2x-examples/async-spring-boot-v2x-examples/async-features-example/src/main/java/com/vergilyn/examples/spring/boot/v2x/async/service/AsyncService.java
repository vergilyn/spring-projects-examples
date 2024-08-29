package com.vergilyn.examples.spring.boot.v2x.async.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class AsyncService {

    @Async
    public LocalDateTime executeAsync(long timeoutMs){
        log.info("#executeAsync() >>>> timeoutMs: {}", timeoutMs);
        if (timeoutMs > 0){
            try {
                TimeUnit.MILLISECONDS.sleep(timeoutMs);
            } catch (InterruptedException ignored) {
            }
        }
        return LocalDateTime.now();
    }
}
