package com.vergilyn.examples.spring.boot.v3x.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = Ehcache3Application.class)
public abstract class AbstractEhcache3ApplicationTest {

    @Autowired
    protected AnnotationConfigApplicationContext applicationContext;

    protected void print(Object msg){
        System.out.printf(LocalTime.now() + " >>>> " + msg).println();
    }

    protected static void sleepSafe(TimeUnit unit, long timeout){
        try {
            unit.sleep(timeout);
        } catch (InterruptedException ignored) {

        }
    }
}
