package com.vergilyn.examples.spring.noscan;

import com.vergilyn.examples.spring.common.UserInfo;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.vergilyn.examples.spring.common.UserBeanNameConstants.no_scan_but_factories_out_class_mismatch;
import static com.vergilyn.examples.spring.common.UserBeanNameConstants.no_scan_but_factories_out_class_mismatch_inner_class;


@Configuration
@ConditionalOnClass(name = "com.xxx.NotExistsClass")
public class NoScanButFactoriesAutoConfiguration {

    @Bean(no_scan_but_factories_out_class_mismatch)
    public UserInfo createBean() {
        return new UserInfo(no_scan_but_factories_out_class_mismatch);
    }

    @Configuration
    static class InnerClass {

        @Bean(no_scan_but_factories_out_class_mismatch_inner_class)
        public UserInfo createInnerBean() {
            return new UserInfo(no_scan_but_factories_out_class_mismatch_inner_class);
        }

    }
}
