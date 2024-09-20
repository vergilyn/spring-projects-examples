package com.vergilyn.examples.spring.service;

import com.alibaba.fastjson.JSON;
import com.vergilyn.examples.spring.AbstractTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.annotation.DirtiesContext;

import static org.assertj.core.api.Assertions.assertThat;

@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
class SpyServiceTest extends AbstractTest {

    @SpyBean
    // @Autowired
    private TestService service;

    @Test
    void test() {

        String username = context.getEnvironment().getProperty("test.username");
        printf("context = %s\n", context);
        printf("environment['test.username'] = %s\n", context.getEnvironment().getProperty("test.username"));

        printf("userInfo = %s\n", JSON.toJSONString(userInfo));

        assertThat(username).isEqualTo("sbtest-2024");

    }

}
