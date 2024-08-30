package com.vergilyn.examples.spring.configuration;

import com.vergilyn.examples.UserInfo;
import com.vergilyn.examples.UserInfoBeanConstants;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.vergilyn.examples.UserInfoBeanConstants.condition_matched_import;

/**
 * 如果，此类存在 {@link Configuration}，且能被 {@link SpringBootApplication#scanBasePackages()} 扫描到。
 * 则，会实例化{@link UserInfoBeanConstants#condition_matched_import}。
 *
 * <p> 如果此类【不存在】{@link Configuration}, 则通过 {@link ConditionMatchedAutoConfiguration} 判断是否执行实例化。
 *
 * @see ConditionMatchedAutoConfiguration
 */
// @Configuration
class ConditionalMatchedImportConfiguration {

    @Bean(condition_matched_import)
    public UserInfo otherBeanInfo(){
        return new UserInfo(condition_matched_import);
    }

}
