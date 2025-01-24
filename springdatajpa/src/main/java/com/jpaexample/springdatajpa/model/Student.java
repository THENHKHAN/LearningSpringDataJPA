package com.jpaexample.springdatajpa.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "jpa_students")
public class Student {

    /*
    IDENTITY: Uses the database's auto-increment mechanism (e.g., MySQL’s AUTO_INCREMENT or SQL Server's IDENTITY).
    AUTO: Lets Hibernate (or the JPA provider) choose the best primary key generation strategy based on the database.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long studentId;
    private String studentName;
    private String about;


    // mapping student entity to laptop
    @OneToOne(mappedBy = "studentRefInLaptopEntityAsFK")
    //Here in Student, Since the mappedBy attribute is present in the Student entity, it means that this entity does not control the foreign key.
    private Laptop laptop;

    // one to many: many address
    @OneToMany()
    private List<Address> addressList ; // or private List<Address> addressList = = new ArrayList<>()

    // getter & setter

    public Student(){

    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", about='" + about + '\'' +
                ", laptop=" + laptop +
                '}';
    }
}
