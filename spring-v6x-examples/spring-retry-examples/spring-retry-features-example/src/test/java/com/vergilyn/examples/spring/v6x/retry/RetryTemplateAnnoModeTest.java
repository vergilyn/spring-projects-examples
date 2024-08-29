package com.vergilyn.examples.spring.v6x.retry;

import org.springframework.context.annotation.Configuration;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;

/**
 * @author vergilyn
 * @see org.springframework.retry.annotation.EnableRetry
 * @see org.springframework.retry.annotation.Retryable
 * @see org.springframework.retry.annotation.Recover
 * @since 2024-01-11
 */
public class RetryTemplateAnnoModeTest {


    @Configuration
    @EnableRetry
    class Application {

    }

    @org.springframework.stereotype.Service
    class Service {

        @Retryable(IllegalArgumentException.class)
        public void service() {
            // ... do something
        }

        @Recover
        public void recover(IllegalArgumentException e) {
            // ... panic
        }
    }
}
