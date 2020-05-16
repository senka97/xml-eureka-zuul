package com.team19.zuul.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class AggregationController {

    @GetMapping("/hello")
    public ResponseEntity<?> get() {
        return new ResponseEntity(String.format("Hello from zuul"), HttpStatus.OK);
    }
}
