package com.vergilyn.examples.spring.test;

import com.vergilyn.examples.spring.SomeClass;
import com.vergilyn.examples.spring.StringAutoConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.FilteredClassLoader;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 用于测试 auto-configuration
 */
class ApplicationContextRunnerTest {

    private final ApplicationContextRunner contextRunner = new ApplicationContextRunner();

    @Test
    void test_basic(){

        contextRunner
                .withUserConfiguration(StringAutoConfiguration.class)
                .run(context -> {

                    assertThat(context).hasBean("matchedString")
                                       .getBean("matchedString").isEqualTo("matched-string");

                    assertThat(context).doesNotHaveBean("mismatchedString");
                });
    }

    @Test
    void test_condition(){

        contextRunner
                .withUserConfiguration(StringAutoConfiguration.class)
                .withClassLoader(new FilteredClassLoader(SomeClass.class))
                .run(context -> {

                    assertThat(context).doesNotHaveBean(SomeClass.class);
                });
    }
}
