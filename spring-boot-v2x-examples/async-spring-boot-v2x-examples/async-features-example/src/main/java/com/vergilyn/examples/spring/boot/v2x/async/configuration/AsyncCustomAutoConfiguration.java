package com.vergilyn.examples.spring.boot.v2x.async.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.task.TaskExecutionAutoConfiguration;
import org.springframework.boot.task.TaskExecutorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * @author vergilyn
 * @see TaskExecutionAutoConfiguration
 * @since 2024-01-15
 */
public class AsyncCustomAutoConfiguration {

    @Bean("customTaskExecutorBuilder")
    // @ConditionalOnMissingBean
    public TaskExecutorBuilder customTaskExecutorBuilder() {
        TaskExecutorBuilder builder = new TaskExecutorBuilder();
        builder = builder.threadNamePrefix("custom-task-executor-builder-");
        return builder;
    }

    @Bean("customTaskExecutor")
    // @ConditionalOnMissingBean(Executor.class)
    public ThreadPoolTaskExecutor customTaskExecutor(@Qualifier("customTaskExecutorBuilder") TaskExecutorBuilder builder) {
        return builder.build();
    }
}
