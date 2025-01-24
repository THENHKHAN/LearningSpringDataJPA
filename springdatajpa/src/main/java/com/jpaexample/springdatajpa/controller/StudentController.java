package com.jpaexample.springdatajpa.controller;

import com.jpaexample.springdatajpa.service.impl.StudentServiceImp;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentServiceImp getStudent;

    // Spring will inject TempCls instance here
    public StudentController(StudentServiceImp getStudent) {
        this.getStudent = getStudent;
    }

    @GetMapping("/")
    public String testingApi(){
        String name = "Noorul";
        String studentInfo = getStudent.getStudentById(2);
//        return String.format("%s, Your api is working great!!!!" , name);
        return String.format("%s, Your API is working great!!!! Student Info: %s", name, studentInfo);    }
}
