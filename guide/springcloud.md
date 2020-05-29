#  组件

注册中心：

- Eureka 、zookeeper、 nacos

服务调用

- Riboon、loadbalancer、openfeign

服务降级

- Hystrix、sentinel

服务网关

- Gateway

服务配置

- Config 、nacos

服务总线

- bus、nacos

 

# Hystrix

- 隔离：将请求封装在HystrixCommand中，然后这些请求在一个独立的线程中执行，每个依赖服务维护一个小的线程池（或信号量），在调用失败或超时的情况下可以断开依赖调用或者返回指定逻辑
- 熔断：当HystrixCommand请求后端服务失败数量超过一定比例(默认50%), 断路器会切换到开路状态(Open). 这时所有请求会直接失败而不会发送到后端服务，断路器保持在开路状态一段时间后(默认5秒)，自动切换到半开路状态(HALF-OPEN)，这时会判断下一次请求的返回情况，     如果请求成功, 断路器切回闭路状态(CLOSED)，否则重新切换到开路状态(OPEN)
- 降级：服务降级是指当请求后端服务出现异常的时候, 可以使用fallback方法返回的值

# gateway

Spring Cloud Gateway 具有如下特性：

- 基于Spring Framework     5, Project Reactor 和 Spring Boot 2.0 进行构建；
- 动态路由：能够匹配任何请求属性；
- 可以对路由指定     Predicate（断言）和 Filter（过滤器）；
- 集成Hystrix的断路器功能；
- 集成 Spring Cloud     服务发现功能；
- 易于编写的     Predicate（断言）和 Filter（过滤器）；
- 请求限流功能；
- 支持路径重写。

集成限流，Spring Cloud Gateway默认集成了Redis限流，可以对不同服务做不同维度的限流，如：IP限流、用户限流 、接口限流

配合 nepxion 插件，可以指定访问服务版本。当前服务为1.0版本，然后启动服务1.2，然后调用接口，更新服务版本（通过参数n-d-version），这样流量就切到1.2版本上了，这就实现了所谓蓝绿发布。

 

# Feign

服务间调用

# config

配置中心

# Bus

用于传播集群状态的消息总线，使用轻量级消息代理链接分布式系统中的节点，可以用来动态刷新集群中的服务配置。

 