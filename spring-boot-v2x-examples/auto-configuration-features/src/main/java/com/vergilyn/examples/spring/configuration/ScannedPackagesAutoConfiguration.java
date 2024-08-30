package com.vergilyn.examples.spring.configuration;

import com.vergilyn.examples.UserInfo;
import com.vergilyn.examples.UserInfoBeanConstants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ScannedPackagesAutoConfiguration {

    @Bean(UserInfoBeanConstants.scanned_packages)
    public UserInfo otherBeanInfo(){
        return new UserInfo(UserInfoBeanConstants.scanned_packages);
    }

}
