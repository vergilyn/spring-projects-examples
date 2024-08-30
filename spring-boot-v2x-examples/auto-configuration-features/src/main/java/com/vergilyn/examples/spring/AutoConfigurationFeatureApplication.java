package com.vergilyn.examples.spring;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

@Slf4j
@SpringBootApplication(scanBasePackages = "com.vergilyn.examples.spring")
// @Import(ExcludeBasePackagesAutoConfiguration.class)  // 不存在`@Configuration`时，也可以使用`@Import`装配
public class AutoConfigurationFeatureApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(AutoConfigurationFeatureApplication.class, args);
        ConfigurableEnvironment environment = context.getEnvironment();
        log.info("{} 启动完成 >>>> 端口号：{}", context.getId(), environment.getProperty("server.port"));
	}
}
