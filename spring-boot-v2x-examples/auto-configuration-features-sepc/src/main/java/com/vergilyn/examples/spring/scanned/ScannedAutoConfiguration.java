package com.vergilyn.examples.spring.scanned;

import com.vergilyn.examples.spring.common.UserInfo;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.vergilyn.examples.spring.common.UserBeanNameConstants.scanned_out_class_mismatch;
import static com.vergilyn.examples.spring.common.UserBeanNameConstants.scanned_out_class_mismatch_inner_class;


@Configuration
@ConditionalOnClass(name = "com.xxx.NotExistsClass")
public class ScannedAutoConfiguration {

    // 由于不存在`com.xxx.NotExistsClass`，因此，未执行该bean的创建。
    @Bean(scanned_out_class_mismatch)
    public UserInfo createBean() {
        return new UserInfo(scanned_out_class_mismatch);
    }

    @Configuration
    static class InnerClass {

        // 【重要】：期望不创建该bean。但，实际会创建。
        // 【疑问】：为什么？ （out-class 不满足conditional，但此 `InnerClass` 位于 base-packages 内。）
        @Bean(scanned_out_class_mismatch_inner_class)
        public UserInfo createInnerBean() {
            return new UserInfo(scanned_out_class_mismatch_inner_class);
        }

    }

}
