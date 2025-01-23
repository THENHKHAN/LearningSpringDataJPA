package com.jpaexample.springdatajpa.model;

import jakarta.persistence.*;

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

    // getter & setter

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Laptop getLaptop() {
        return laptop;
    }

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
