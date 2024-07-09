package com.ey.producerdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hellop")
public class HelloController {
    @GetMapping("/greet")                    // http://localhost:8081/hellop/greet
    public String getMessage(){
        return "I am hello producer";
    }
}
