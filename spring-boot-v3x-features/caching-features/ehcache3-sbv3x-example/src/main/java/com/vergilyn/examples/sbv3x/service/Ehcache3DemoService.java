package com.vergilyn.examples.sbv3x.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class Ehcache3DemoService {

	@Cacheable(key = "'ehcache:' + #p0", cacheNames = "ehcache3-cache-name")
	public LocalTime getTime(String key){
		return LocalTime.now();
	}
}
