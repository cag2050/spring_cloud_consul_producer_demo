package com.cag2050.spring_cloud_consul_producer_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudConsulProducerDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConsulProducerDemoApplication.class, args);
    }

}
