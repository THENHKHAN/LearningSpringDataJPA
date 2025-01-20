package com.jpaexample.springdatajpa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @GetMapping("/test")
    public String testingApi(){
        String name = "Noorul";
        return String.format("%s, Your api is working great!!!!" , name);
    }
}
