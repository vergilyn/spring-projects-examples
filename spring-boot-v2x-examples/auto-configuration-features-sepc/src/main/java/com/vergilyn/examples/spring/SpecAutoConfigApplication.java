package com.vergilyn.examples.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

@Slf4j
@SpringBootApplication(scanBasePackages = {
        "com.vergilyn.examples.spring.scanned"
        // , "com.vergilyn.examples.spring.noscan"
})
public class SpecAutoConfigApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpecAutoConfigApplication.class, args);
        ConfigurableEnvironment environment = context.getEnvironment();
        log.info("{} 启动完成 >>>> 端口号：{}", context.getId(), environment.getProperty("server.port"));
    }

}
