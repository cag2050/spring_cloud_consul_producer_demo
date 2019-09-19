package com.cag2050.spring_cloud_consul_producer_demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GatewayController {
    @Value("${server.port}")
    String port;

    @RequestMapping("/foo")
    String foo(String foo) {
        return "参数 foo 的值是：" + foo + "，from port：" + port;
    }
}
