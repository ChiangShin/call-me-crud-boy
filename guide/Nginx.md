# 先放着 有时间看看  

https://www.jianshu.com/p/bed000e1830b

# 特点

内存占用小、并发量高，支持50000个并发连接

# 基本概念

1. **反向代理**

- 正向代理：在客户端（浏览器）配置代理服务器，通过代理服务器进行互联网访问
- 反向代理：客户端对代理是无感知的，因为客户端不需要任何配置就可以访问。只要将请求发送到反向代理服务器，由反向代理服务器去选择目标服务器获取数据，再返回给客户端，此时反向代理服务器和目标服务器对外就是一个服务器，暴露的是反向代理服务器地址，隐藏了真实服务器ip地址。

1. **负载均衡**

- 将多个请求分发到各个服务器上。

1. **动静分离**

- 为了加快网站的解析速度，可以把动态资源和静态资源由不同的服务器来解析，加快解析速度，降低原来单个服务器的压力。

# 安装

1. **linux****中安装****nginx**

- Docker 安装nignx ,
- 将各种配置文件及html目录挂载到宿主机上(-v     /docker/nginx/nginx.conf:/etc/nginx/nginx.conf)

 

1. **nginx****常用命令**
2. **nginx****配置文件**

- 全局块：worker_processes     1 值越大，可以支持的并发处理量越多
- events块：涉及的指令主要影响nginx服务器与用户的网络连接
- http块：

# nginx配置实例-反向代理

# nginx配置实例-负载均衡

# nginx配置实例-动静分离

# nginx原理

 