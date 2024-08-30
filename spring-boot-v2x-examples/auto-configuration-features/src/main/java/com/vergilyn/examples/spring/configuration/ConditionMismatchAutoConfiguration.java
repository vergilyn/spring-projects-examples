package com.vergilyn.examples.spring.configuration;

import com.vergilyn.examples.UserInfo;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import static com.vergilyn.examples.UserInfoBeanConstants.condition_mismatch;

@Configuration
@ConditionalOnClass(name = "com.xxx.NotExistsClass")
@Import({ConditionalMatchedImportConfiguration.class})
public class ConditionMismatchAutoConfiguration {


    @Bean(condition_mismatch)
    public UserInfo otherBeanInfo(){
        return new UserInfo(condition_mismatch);
    }

}
