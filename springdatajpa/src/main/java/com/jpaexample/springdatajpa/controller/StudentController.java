package com.jpaexample.springdatajpa.controller;

import com.jpaexample.springdatajpa.service.TempCls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final TempCls tempCls;

    // Spring will inject TempCls instance here
    public StudentController(TempCls tempCls) {
        this.tempCls = tempCls;
    }

    @GetMapping("/test")
    public String testingApi(){
        String name = "Noorul";
        String studentInfo = tempCls.getStudent(2);
//        return String.format("%s, Your api is working great!!!!" , name);
        return String.format("%s, Your API is working great!!!! Student Info: %s", name, studentInfo);    }
}
