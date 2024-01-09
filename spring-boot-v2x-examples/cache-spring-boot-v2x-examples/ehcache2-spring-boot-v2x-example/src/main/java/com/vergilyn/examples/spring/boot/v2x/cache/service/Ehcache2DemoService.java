package com.vergilyn.examples.spring.boot.v2x.cache.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class Ehcache2DemoService {
	/**
	 * 参考：`ehcache2.xml`.
	 */
	public static final String EHCACHE_CACHE_NAME = "ehcache2-demo-cache";


	@Cacheable(key = "'ehcache:' + #p0", cacheNames = EHCACHE_CACHE_NAME)
	public LocalTime getTime(String key){
		return LocalTime.now();
	}
}
