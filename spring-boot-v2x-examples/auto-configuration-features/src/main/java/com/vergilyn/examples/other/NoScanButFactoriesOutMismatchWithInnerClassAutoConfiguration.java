package com.vergilyn.examples.other;

import com.vergilyn.examples.UserInfo;
import com.vergilyn.examples.UserInfoBeanConstants;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(name = "com.xxx.NoExistsClass")
public class NoScanButFactoriesOutMismatchWithInnerClassAutoConfiguration {

    @Configuration
    static class InnerClass {

        @Bean(UserInfoBeanConstants.no_scan_but_factories_out_mismatch_inner)
        public UserInfo otherBeanInfo(){
            return new UserInfo(UserInfoBeanConstants.no_scan_but_factories_out_mismatch_inner);
        }

    }

}
