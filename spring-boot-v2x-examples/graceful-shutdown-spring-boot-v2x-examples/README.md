# graceful-shutdown-spring-boot-v2x-examples

IDEA 中的 debug shutdown？  
可以通过依赖`spring-boot-actuator`，通过调用`https://ip:port/actuator/shutdown`。

```properties
management.endpoint.shutdown.enabled=true
```