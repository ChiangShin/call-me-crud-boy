实际操作一下

 

docker images

docker run -p 8761:8761 -name redis1 redis

docker exec -it redis1 /bin/bash

docker ps -a

docker start redis1

docker stop redis1

docker search -s 50 redis