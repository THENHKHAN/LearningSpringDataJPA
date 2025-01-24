package com.jpaexample.springdatajpa.repository;

import com.jpaexample.springdatajpa.model.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface LaptopRepo extends JpaRepository<Laptop, Long> {
}
