package com.team19.zuul.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "user")
public interface UserClient {

    @GetMapping("/helloAdmin")
    String helloAdmin();

    @GetMapping("/helloClient")
    String helloClient();

    @GetMapping("/helloAgent")
    String helloAgent();

    @PostMapping("/helloAdmin")
    String postAdmin();

    @PostMapping("/helloAgent")
    String postAgent();

    @PostMapping("/helloClient")
    String postClient();
}
