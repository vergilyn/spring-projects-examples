package com.vergilyn.examples.spring.configuration;

import com.vergilyn.examples.UserInfo;
import org.springframework.context.annotation.Bean;

import static com.vergilyn.examples.UserInfoBeanConstants.condition_mismatch_import;

// @Configuration
class ConditionalMismatchImportConfiguration {

    @Bean(condition_mismatch_import)
    public UserInfo otherBeanInfo(){
        return new UserInfo(condition_mismatch_import);
    }

}
