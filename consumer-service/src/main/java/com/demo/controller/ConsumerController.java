package com.demo.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/consumer")
public class ConsumerController {
    @GetMapping("ping")
    public ResponseEntity ping() {
        return ResponseEntity.ok("ping");
    }
}
