package com.vergilyn.examples.spring.scanned;

import com.vergilyn.examples.spring.common.UserInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.vergilyn.examples.spring.common.UserBeanNameConstants.scanned_only_inner_class;

public class ScannedOnlyInnerClassAutoConfiguration {

    @Configuration
    static class InnerClass {

        // 会创建bean。
        @Bean(scanned_only_inner_class)
        public UserInfo createInnerBean() {
            return new UserInfo(scanned_only_inner_class);
        }

    }
}
