package com.vergilyn.examples.sbv3x;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 *
 * @author vergilyn
 * @since 2023-03-01
 *
 * @see org.springframework.boot.autoconfigure.cache.JCacheCacheConfiguration
 */
@Slf4j
@EnableCaching
@SpringBootApplication
public class Ehcache3Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Ehcache3Application.class, args);
        ConfigurableEnvironment environment = context.getEnvironment();
        log.info("{} 启动完成 >>>> 端口号：{}", context.getId(), environment.getProperty("server.port"));
    }

}
