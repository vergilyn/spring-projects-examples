package com.vergilyn.examples.spring.config;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.boot.context.config.DelegatingApplicationListener;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.context.support.AbstractApplicationContext;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class ApplicationEventMulticasterProxyConfiguration {

    @Bean(AbstractApplicationContext.APPLICATION_EVENT_MULTICASTER_BEAN_NAME)
    public ApplicationEventMulticaster applicationEventMulticaster(){

        return new ApplicationEventMulticasterProxy();
    }

    @Slf4j
    public static class ApplicationEventMulticasterProxy extends SimpleApplicationEventMulticaster {

        @Override
        protected void invokeListener(ApplicationListener<?> listener, ApplicationEvent event) {

            String prefix = String.format("event: %s, \t\t listener: %s", event.getClass().getSimpleName(), listener.getClass().getSimpleName());

            log.info("{} #invokeListener BEFORE >>>> ", prefix);

            if (listener.getClass() != DelegatingApplicationListener.class) {
                log.info("{} #invokeListener actuator/health >>>> {}", prefix, requestHealthEndpoint());
            }


            super.invokeListener(listener, event);
            log.info("{} #invokeListener AFTER <<<< ", prefix);

        }

        @SneakyThrows
        private String requestHealthEndpoint() {

            InputStream inputStream = null;
            try {

                URL url = new URL("http://127.0.0.1:28081/actuator/health");

                URLConnection urlConnection = url.openConnection();

                urlConnection.setConnectTimeout(200);
                urlConnection.setReadTimeout(200);
                inputStream = urlConnection.getInputStream();
                return IOUtils.toString(inputStream, "UTF-8");
            } catch (Exception e) {

            } finally {
                IOUtils.closeQuietly(inputStream);
            }

            return "NULL";
        }
    }
}
