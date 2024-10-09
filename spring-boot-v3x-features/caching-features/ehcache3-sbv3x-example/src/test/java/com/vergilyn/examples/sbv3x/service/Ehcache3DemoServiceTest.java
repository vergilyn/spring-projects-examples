package com.vergilyn.examples.sbv3x.service;

import com.vergilyn.examples.sbv3x.AbstractEhcache3ApplicationTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

class Ehcache3DemoServiceTest extends AbstractEhcache3ApplicationTest {

    @Autowired
    private Ehcache3DemoService ehcache3DemoService;

    /**
     * 参考`ehcache-jsr107.xml`中 `ehcache3-cache-name`：
     * <pre>{@code
     *     <cache alias="ehcache3-cache-name" uses-template="ehcache3-cache-template"/>
     *
     *     <cache-template name="ehcache3-cache-template">
     *         <key-type>java.lang.String</key-type>
     *         <expiry>
     *             <ttl unit="millis">500</ttl>
     *         </expiry>
     *         <heap unit="entries">2000</heap>
     *     </cache-template>
     *     />
     * }</pre>
     */
    @Test
    void getTime() {
        String key = "time-01";

        LocalTime time0 = getTimeDelay(key, 0);
        LocalTime time1 = getTimeDelay(key, 100);
        LocalTime time3 = getTimeDelay(key, 300);
        LocalTime time5 = getTimeDelay(key, 500);

        System.out.println("time0 >>>> " + time0);
        System.out.println("time1 >>>> " + time1);
        System.out.println("time3 >>>> " + time3);
        System.out.println("time5 >>>> " + time5);

        Assertions.assertThat(time0)
                  .isEqualTo(time1)
                  .isEqualTo(time3)
                  .isBefore(time5);

    }

    private LocalTime getTimeDelay(String key, long delayMillis){
        sleepSafe(TimeUnit.MILLISECONDS, delayMillis);

        return ehcache3DemoService.getTime(key);
    }
}