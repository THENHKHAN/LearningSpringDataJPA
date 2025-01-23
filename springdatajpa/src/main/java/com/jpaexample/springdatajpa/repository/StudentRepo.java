package com.jpaexample.springdatajpa.repository;

import com.jpaexample.springdatajpa.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Long> {
}
