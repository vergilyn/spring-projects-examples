package com.vergilyn.examples.spring.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;

import java.util.concurrent.TimeUnit;

public class ApplicationStartedEventListenerConfiguration {

    @Bean
    public CustomApplicationStartedEventListener customApplicationStartedEventListener(){

        return new CustomApplicationStartedEventListener();
    }

    @Slf4j
    public static class CustomApplicationStartedEventListener implements ApplicationListener<ApplicationStartedEvent>, Ordered {

        @Override
        public void onApplicationEvent(ApplicationStartedEvent event) {
            log.info("[ApplicationStartedEvent] >>>> sleep: 60 min");
            try {
                TimeUnit.MINUTES.sleep(60);
            } catch (InterruptedException ignored) {

            }
        }

        @Override
        public int getOrder() {
            return Ordered.HIGHEST_PRECEDENCE;
        }
    }
}
