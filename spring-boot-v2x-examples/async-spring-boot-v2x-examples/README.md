# Async 

+ <https://docs.spring.io/spring-boot/docs/2.7.14/reference/html/features.html#features.task-execution-and-scheduling>

- `org.springframework.boot.autoconfigure.task.TaskExecutionAutoConfiguration`

任何自定义的`TaskExecutorBuilder` 或 `ThreadPoolTaskExecutor`，都会覆盖**默认的自动装配**。


## FAQ
### 当存在多个`TaskExecutor`，且未指定`@Primary`或`name = "taskExecutor"`

```text
AnnotationAsyncExecutionInterceptor : 
  More than one TaskExecutor bean found within the context, and none is named 'taskExecutor'. 
  Mark one of them as primary or name it 'taskExecutor' (possibly as an alias) in order to use it for async processing: [customTaskExecutor, customOtherTaskExecutor]
```

但是，还是会正常执行`@Async`，用的是`SimpleAsyncTaskExecutor`:  

- `org.springframework.aop.interceptor.AsyncExecutionInterceptor#getDefaultExecutor()`

**参考：**  
> [#29621 Allow providing additional ThreadPoolTaskExecutor while keeping TaskExecutionAutoConfiguration](https://github.com/spring-projects/spring-boot/issues/29621)  
> spring-boot设计的`TaskExecutor`特性如此，如果存在自定义，则不会实例化默认`applicationTaskExecutor`。
> 详见：`TaskExecutionAutoConfiguration`等自动装配的配置类，均使用了`@ConditionalOnMissingBean`

**解决方式：**  
需要区分时，自定义创建多个`taskExecutor`，并将其中的某个定义成`@Primary` 或者 `name = "taskExecutor"`（例如`TaskExecutionAutoConfiguration`）

###

[#23818 Add metrics support for ThreadPoolTaskExecutor and ThreadPoolTaskScheduler](https://github.com/spring-projects/spring-boot/issues/23818)