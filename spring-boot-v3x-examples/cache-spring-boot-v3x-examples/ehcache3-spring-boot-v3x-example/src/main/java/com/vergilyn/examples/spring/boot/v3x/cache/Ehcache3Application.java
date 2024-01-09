package com.vergilyn.examples.spring.boot.v3x.cache;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;

/**
 *
 * @author vergilyn
 * @since 2023-03-01
 *
 * @see org.springframework.boot.autoconfigure.cache.JCacheCacheConfiguration
 */
@SpringBootApplication
@EnableCaching
@Slf4j
public class Ehcache3Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(Ehcache3Application.class, args);

		log.info("{} >>>> 启动完成 <<<<", applicationContext.getId());
	}

}
