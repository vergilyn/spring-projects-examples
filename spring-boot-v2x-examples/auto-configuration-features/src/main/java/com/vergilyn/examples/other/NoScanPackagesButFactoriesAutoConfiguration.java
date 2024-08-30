package com.vergilyn.examples.other;

import com.vergilyn.examples.UserInfo;
import com.vergilyn.examples.UserInfoBeanConstants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NoScanPackagesButFactoriesAutoConfiguration {

    @Bean(UserInfoBeanConstants.no_scan_packages_but_factories)
    public UserInfo createBean(){
        return new UserInfo(UserInfoBeanConstants.no_scan_packages_but_factories);
    }



}
