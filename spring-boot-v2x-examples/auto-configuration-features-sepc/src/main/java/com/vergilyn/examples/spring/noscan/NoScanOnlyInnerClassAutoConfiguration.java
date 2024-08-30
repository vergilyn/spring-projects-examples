package com.vergilyn.examples.spring.noscan;

import com.vergilyn.examples.spring.common.UserInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.vergilyn.examples.spring.common.UserBeanNameConstants.no_scan_only_inner_class;

public class NoScanOnlyInnerClassAutoConfiguration {

    @Configuration
    static class InnerClass {

        @Bean(no_scan_only_inner_class)
        public UserInfo createInnerBean() {
            return new UserInfo(no_scan_only_inner_class);
        }

    }
}
