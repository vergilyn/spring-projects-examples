package com.vergilyn.examples.spring.configuration;

import com.vergilyn.examples.UserInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.vergilyn.examples.UserInfoBeanConstants.condition_mismatch_import_but_scanned;

@Configuration
class ConditionalMismatchImportButScannedConfiguration {

    @Bean(condition_mismatch_import_but_scanned)
    public UserInfo otherBeanInfo(){
        return new UserInfo(condition_mismatch_import_but_scanned);
    }

}
