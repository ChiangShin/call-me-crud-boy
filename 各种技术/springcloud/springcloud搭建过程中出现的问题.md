- 最上层的pom.xml中 需要设置<packaging>pom</packaging>

- 子项目的pom.xml中 需要设置<packaging>jar</packaging> ,否则子项目启动时 会报
	
	> TransportException: Cannot execute request on any known server

- 使用配置中心配置参数，git中必须要有${spring.application.name}-dev.yml 文件，否则会报
    >Caused by: java.lang.IllegalArgumentException: Could not resolve placeholder 'from' in string value "${from}"

    ```yml
    spring:
      application:
        name: demo-server
      cloud:
        config:
          name: ${spring.application.name}
          profile: dev
          label: master
          uri: http://localhost:8001/
    ```
    - 服务从配置中心获取服务，当配置中心为单个节点时 bootstrap.yml中配置
    > uri: http://localhost:8001/ 

    是可以连通的。
    使用高可用的配置中心，改为
    >       discovery:
    >        enabled: true
    >        service-id: spring-cloud-config-server

    会报异常

	> cannot execute request 或者 Could not resolve placeholder 'from' in string value "${from}"
	
	原因是，在项目启动时，eureka.client.serviceUrl. defaultZone必须写在discovery.enabled.service-id前面，否则不知道去哪里获取配置中心地址。干脆把这两个参数都配置到bootstrap.yml中
	
	```yml
	server:
	  port: 9000
	eureka:
	  client:
	    serviceUrl:
	      defaultZone: http://root:123456@localhost:8761/eureka/
	spring:
	  application:
	    name: demo-server
	  cloud:
	    config:
	      name: ${spring.application.name}
	      profile: dev
	      label: master
	      discovery:
	        enabled: true
	        service-id: spring-cloud-config-server
	```

- spring boot maven打包，jar太小，只有4kb,报"没有主清单XXX"，添加

  ```xml
      <parent>
          <groupId>org.springframework.boot</groupId>
          <artifactId>spring-boot-starter-parent</artifactId>
          <version>2.0.8.RELEASE</version>
      </parent>
  ```

  