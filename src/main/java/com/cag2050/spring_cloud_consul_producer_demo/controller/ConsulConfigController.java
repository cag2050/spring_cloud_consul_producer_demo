package com.cag2050.spring_cloud_consul_producer_demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConsulConfigController {
//    @Value("${foo.bar}")
//    String fooBar;
//
//    @RequestMapping("/foobar")
//    String getFooBar() {
//        return fooBar;
//    }
}
