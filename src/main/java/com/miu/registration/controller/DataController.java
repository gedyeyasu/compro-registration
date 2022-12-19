package com.miu.registration.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataController {

    @GetMapping("/version")
    public String version(){
        return "Version 1.0.0";
    }

    @GetMapping("/")
    public String health(){
        return "OK";
    }

}
