package com.vergilyn.examples.spring.configuration;

import com.vergilyn.examples.UserInfo;
import com.vergilyn.examples.UserInfoBeanConstants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// @Configuration
// @ConditionalOnClass(name = "com.xxx.NoExistsClass")
public class InnerClassButOutMismatchAutoConfiguration {


    @Bean(UserInfoBeanConstants.scan_package_out_mismatch)
    public UserInfo creatBean(){
        return new UserInfo(UserInfoBeanConstants.scan_package_out_mismatch);
    }

    @Configuration
    static class InnerClass {

        /**
         * 【！！！重要】：会被调用。 即使 out-class 不添加 {@link Configuration}，或者 mismatch
         */
        @Bean(UserInfoBeanConstants.scan_package_out_mismatch_inner)
        public UserInfo creatBean(){
            return new UserInfo(UserInfoBeanConstants.scan_package_out_mismatch_inner);
        }

    }

}
