package com.team19.zuul.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "user")
public interface UserClient {

    @GetMapping("/hello")
    String hello();
}
