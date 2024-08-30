package com.vergilyn.examples.spring.configuration;

import com.vergilyn.examples.UserInfo;
import com.vergilyn.examples.UserInfoBeanConstants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InnerClassAutoConfiguration {

    @Configuration
    public static class InnerClass {

        @Bean(UserInfoBeanConstants.inner_class_bean)
        public UserInfo otherBeanInfo(){
            return new UserInfo(UserInfoBeanConstants.inner_class_bean);
        }


    }

}
