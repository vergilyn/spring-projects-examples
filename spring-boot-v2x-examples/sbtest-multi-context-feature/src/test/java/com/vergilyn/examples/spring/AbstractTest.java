package com.vergilyn.examples.spring;

import com.vergilyn.examples.spring.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest(classes = TestApplication.class)
public abstract class AbstractTest {

    @Autowired
    protected ApplicationContext context;
    @Autowired
    protected ConfigurableListableBeanFactory beanFactory;

    @Autowired
    protected UserInfo userInfo;

    protected final void printf(String format, Object... args) {
        System.out.printf("[" + this.getClass().getSimpleName() + "] >>>> " + format, args);
    }
}
