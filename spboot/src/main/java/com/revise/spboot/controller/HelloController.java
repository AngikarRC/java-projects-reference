package com.revise.spboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello-world-today")
    public String helloWorld(){
        return "Welcome to Revision. Hope you enjoy!!!!!";
    }
}


