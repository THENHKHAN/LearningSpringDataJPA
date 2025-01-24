package com.jpaexample.springdatajpa.service.impl;

import com.jpaexample.springdatajpa.model.Laptop;
import com.jpaexample.springdatajpa.model.Student;
import com.jpaexample.springdatajpa.repository.LaptopRepo;
import com.jpaexample.springdatajpa.repository.StudentRepo;
import com.jpaexample.springdatajpa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImp implements StudentService {

    private StudentRepo studentRepo;
    private LaptopRepo laptopRepo;

    public StudentServiceImp(){

    }

    // constructor based dependencies injection
    @Autowired
    /*
    Why it was not working if omitted Autowired:
    If there are multiple constructors, Spring needs the @Autowired annotation to know which constructor to use for dependency injection. Otherwise, it cannot decide which one to use, and it will throw an exception.
     */
    public StudentServiceImp(StudentRepo studentRepo, LaptopRepo laptopRepo){
        this.laptopRepo = laptopRepo;
        this.studentRepo = studentRepo;
    }

    @Override
    public String getStudentById(long id){
        // Fetch the student by ID
        Student student = studentRepo.findById(id).orElse(null);

        if (student != null) {
            // Check if the student has an associated laptop
            if (student.getLaptop() != null) {
                // If a laptop is associated, retrieve and print laptop details
                Laptop laptop = student.getLaptop();
                String laptopInfo = "Laptop Info: Model - " + laptop.getModelNumber() + ", Brand - " + laptop.getBrand();
                System.out.println("student name : " + student.getStudentName());
                System.out.println("laptop brand: " + laptop.getBrand());
                System.out.println("student name FROM laptop with FK: " + laptop.getStudentRefInLaptopEntityAsFK().getStudentName());
                return "studentInfo AND Laptop  found-----> ";
            } else {
                return "No laptop associated with this student.";
            }
        } else {
            return "Student not found!";
        }
    }


}
