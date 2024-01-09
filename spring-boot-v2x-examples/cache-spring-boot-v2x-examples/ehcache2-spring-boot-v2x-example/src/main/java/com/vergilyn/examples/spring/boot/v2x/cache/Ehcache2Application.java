package com.vergilyn.examples.spring.boot.v2x.cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 *
 * @author vergilyn
 * @since 2023-03-01
 *
 * @see org.springframework.boot.autoconfigure.cache.EhCacheCacheConfiguration
 */
@SpringBootApplication
@EnableCaching
public class Ehcache2Application {

	public static void main(String[] args) {
		SpringApplication.run(Ehcache2Application.class, args);
	}
}
