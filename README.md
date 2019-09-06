Spring Cloud 集成 Consul（服务注册与发现）：2个服务端里的第1个

### 步骤一：创建 Consul 容器
1.镜像官方网址：https://hub.docker.com/_/consul
2.pull 镜像：
```
docker pull consul:1.6.0
```
3.创建容器（默认http管理端口：8500）
```
docker run -p 8500:8500 consul:1.6.0
```
4.访问管理网址
```
http://localhost:8500/
```

### 步骤二：创建项目
1.参考：http://ityouknow.com/springcloud/2018/07/20/spring-cloud-consul.html

### 参考
资料 | 网址
--- | ---
springcloud(十三)：注册中心 Consul 使用详解 | http://ityouknow.com/springcloud/2018/07/20/spring-cloud-consul.html
