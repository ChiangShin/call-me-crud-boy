docker 可以认为是一个集装箱，里面封装打包了一整套指定的环境（比如centos、redis、kafka、MySQL、tomcat...），我们可以通过简单地获取镜像、启动容器，就可以快速部署一个相同的运行环境。通过docker可以保证线上线下的环境一致。



**常用的命令** 

列出所有镜像  docker images

启动容器并端口映射  docker run -p 8761:8761 -name redis1 redis

进入容器 docker exec -it redis1 /bin/bash

查看历史容器  docker ps -a

开始 docker start redis1

停止 docker stop redis1

查找start数大于50的redis镜像    docker search -s 50 redis