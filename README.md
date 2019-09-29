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

### 步骤三：使用 Spring Cloud Consul Config 做服务配置中心
1.pom.xml 添加依赖
```
<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-consul-config</artifactId>
</dependency>
```
2.application.properties 添加以下配置
```
spring.profiles.active=dev
```
3.新建并编辑 src/main/resources/bootstrap.yml

4.访问consul的KV存储管理界面，即 http://localhost:8500/ui/dc1/kv，创建一条记录，key值为：config/spring-cloud-consul-producer:dev/data，value值如下:
```
foo:
  bar: bar1
server:
  port: 8081
```
5.新建并编辑：src/main/java/com/cag2050/spring_cloud_consul_producer_demo/controller/ConsulConfigController.java

6.启动工程，可以看到程序的启动端口为8081，即是consul的配置中心配置的server.port端口。
  工程启动完成后，在浏览器上访问 http://localhost:8081/foobar，页面显示bar1。由此可知，已经成功从consul的配置中心读取了配置foo.bar的配置。
  
7.当使用spring cloud config作为配置中心的时候，可以使用spring cloud config bus支持动态刷新配置。Spring Cloud Comsul Config默认就支持动态刷新，只需要在需要动态刷新的类上加上@RefreshScope注解即可。重新启动此工程，在浏览器上访问http://localhost:8081/foobar，页面显示bar1。然后在网页上访问consul的KV存储的管理界面，即http://localhost:8500/ui/dc1/kv，修改config/spring-cloud-consul-producer:dev/data的值，修改后的值如下：
```
foo:
  bar: bar2
server: 
  port: 8081
```
此时不重新启动此工程，在浏览器上访问http://localhost:8081/foobar，页面显示bar2。可见foo.bar的最新配置在应用不重启的情况下已经生效。

### 问题：
* 问题：此处依赖需要用 spring-cloud-consul-config，用 spring-cloud-starter-consul-config 会提示找不到；那 spring-cloud-starter-consul-config
 和 spring-cloud-consul-config 区别是什么？从网上没有搜到答案，待跟进。
* 解决：好像都可以。
可以通过下面的网址，看到依赖的 Group / Artifact。
1. https://mvnrepository.com/artifact/org.springframework.cloud/spring-cloud-consul-config/2.1.3.RELEASE
2. https://mvnrepository.com/artifact/org.springframework.cloud/spring-cloud-starter-consul-config/2.1.2.RELEASE

> 参考：https://juejin.im/post/5c650f23e51d45012d0663d4#heading-10

### 参考
资料 | 网址
--- | ---
springcloud(十三)：注册中心 Consul 使用详解 | http://ityouknow.com/springcloud/2018/07/20/spring-cloud-consul.html
使用Spring Cloud Consul Config来做服务配置中心 | https://juejin.im/post/5c650f23e51d45012d0663d4#heading-10
