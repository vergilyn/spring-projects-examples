package com.vergilyn.examples.spring;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StringAutoConfiguration {

    public static final String BEAN_NAME_MATCHED= "matchedString";
    public static final String BEAN_NAME_MISMATCHED= "mismatchedString";

    @ConditionalOnClass(String.class)
    @Bean(BEAN_NAME_MATCHED)
    public String matchedString() {
        return "matched-string";
    }

    @ConditionalOnClass(name = "com.unknown.XClass")
    @Bean(BEAN_NAME_MISMATCHED)
    public String mismatchedString() {
        return "mismatched-string";
    }

    @ConditionalOnClass(SomeClass.class)
    @Bean
    public SomeClass someClassString() {
    	return new SomeClass();
    }

}
