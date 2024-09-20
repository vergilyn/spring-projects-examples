package com.vergilyn.examples.spring.config;

import com.vergilyn.examples.spring.model.UserInfo;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.atomic.AtomicLong;

@Configuration
@ConfigurationProperties(prefix = "test.user")
public class UserConfiguration {

    private static final AtomicLong ID_GENERATOR = new AtomicLong(0);

    @Setter
    @Getter
    private String name;

    @Bean
    public UserInfo userInfo(){

        UserInfo userInfo = new UserInfo();
        userInfo.setId(ID_GENERATOR.incrementAndGet());
        userInfo.setName(name);

        return userInfo;
    }
}
