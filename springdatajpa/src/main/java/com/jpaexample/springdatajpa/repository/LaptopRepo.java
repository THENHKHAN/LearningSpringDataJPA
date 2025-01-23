package com.jpaexample.springdatajpa.repository;

import com.jpaexample.springdatajpa.model.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaptopRepo extends JpaRepository<Laptop, Long> {
}
