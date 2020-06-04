## 使用docker 安装单机版的kafka，并使用python脚本往里面持续产生数据

- 当前虚拟机的ip为 192.168.1.200

- 安装 docker和 compose，自行搜索

- 创建kafka和zookeeper容器

    创建文件 /opt/docker/kafka/docker-compose.yml

    ```yml
    version: '3'
    services:
      zookeeper:
        image: wurstmeister/zookeeper
        ports:
          - "2181:2181"
      kafka:
        image: wurstmeister/kafka
        depends_on: [ zookeeper ]
        ports:
          - "9092:9092"
        environment:
          KAFKA_ADVERTISED_HOST_NAME: 192.168.1.200
          KAFKA_CREATE_TOPICS: "test:1:1"
          KAFKA_ZOOKEEPER_CONNECT: zookeeper:2181
        volumes:
          - /var/run/docker.sock:/var/run/docker.sock
    
    ```

- 在/opt/docker/kafka/ 文件夹下执行  docker-compose up -d  启动容器

- pip 安装kafka包

  > pip install kafka

  如果出现错误

  > C:\ProgramData\Anaconda3\python.exe C:/git/base_function/kafka_usage.py
  > Traceback (most recent call last):
  > File "C:/git/base_function/kafka_usage.py", line 6, in <module>
  >    from kafka import KafkaProducer
  >    File "C:\ProgramData\Anaconda3\lib\site-packages\kafka\__init__.py", line 23, in <module>
  >    from kafka.producer import KafkaProducer
  >    File "C:\ProgramData\Anaconda3\lib\site-packages\kafka\producer\__init__.py", line 4, in <module>
  >    from .simple import SimpleProducer
  >    File "C:\ProgramData\Anaconda3\lib\site-packages\kafka\producer\simple.py", line 54
  >    return '<SimpleProducer batch=%s>' % self.async
  >                                                   ^
  >    SyntaxError: invalid syntax

  因为py3.7里面async已经变成了关键字。所以导致了不兼容。

  解决办法：
  使用最新的kafka版本，但是pyPI上的kafka还没有被替换成最新的，可以使用下面的方法升级kafka python

  > pip install kafka-python

- 使用python脚本持续产数

  ```python
  from kafka import KafkaProducer
  import json
  import time
  
  '''
   生产者demo
   向test_lyl2主题中循环写入10条json数据
   注意事项：要写入json数据需加上value_serializer参数，如下代码
  '''
  if __name__ == '__main__':
      producer = KafkaProducer(
             value_serializer=lambda v: json.dumps(v).encode('utf-8'),
             bootstrap_servers=['192.168.1.200:9092']
             )
      num = 0
      while True:
          time.sleep(3)
          num = num + 1
          data = {
              "name": "李山江",
              "age": 23,
              "gender": "男",
              "id": num,
              "time": time.time()
          }
          producer.send('test', data)
  
  ```

  