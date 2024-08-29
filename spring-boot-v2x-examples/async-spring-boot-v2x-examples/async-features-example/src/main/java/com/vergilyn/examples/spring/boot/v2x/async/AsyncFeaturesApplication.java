package com.vergilyn.examples.spring.boot.v2x.async;


import com.vergilyn.examples.spring.boot.v2x.async.configuration.AsyncCustomAutoConfiguration;
import com.vergilyn.examples.spring.boot.v2x.async.configuration.AsyncCustomOtherAutoConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;

@Slf4j
@EnableAsync
@SpringBootApplication
@ImportAutoConfiguration(classes = {AsyncCustomAutoConfiguration.class, AsyncCustomOtherAutoConfiguration.class})
public class AsyncFeaturesApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(AsyncFeaturesApplication.class);

        ConfigurableApplicationContext context = application.run(args);

        log.info("{} 启动完成, port: {} <<<< ", application.getMainApplicationClass().getSimpleName(), context.getEnvironment().getProperty("server.port"));
    }
}
