package com.vergilyn.examples.spring.boot.v2x.cache.service;

import com.vergilyn.examples.spring.boot.v2x.cache.AbstractEhcache2ApplicationTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class Ehcache2DemoServiceTest extends AbstractEhcache2ApplicationTest {

    @Autowired
    private Ehcache2DemoService ehcache2DemoService;

    /**
     * 参考`ehcache2.xml`中 `ehcache-demo-cache`：
     * <pre>{@code
     *      <cache name="ehcache2-demo-cache"
     *            maxEntriesLocalHeap="500"
     *            eternal="false"
     *            timeToIdleSeconds="5"
     *            timeToLiveSeconds="5"
     *            diskExpiryThreadIntervalSeconds="1"
     *     />
     * }</pre>
     */
    @Test
    void getTime() {
        String key = "time-01";

        LocalTime time0 = getTimeDelay(key, 0);
        LocalTime time1 = getTimeDelay(key, 1);
        LocalTime time3 = getTimeDelay(key, 3);
        LocalTime time5 = getTimeDelay(key, 5);

        System.out.println("time0 >>>> " + time0);
        System.out.println("time1 >>>> " + time1);
        System.out.println("time3 >>>> " + time3);
        System.out.println("time5 >>>> " + time5);

        Assertions.assertThat(time0)
                  .isEqualTo(time1)
                  .isEqualTo(time3)
                  .isBefore(time5);

    }

    private LocalTime getTimeDelay(String key, long delaySeconds){
        sleepSafe(TimeUnit.SECONDS, delaySeconds);

        return ehcache2DemoService.getTime(key);
    }
}