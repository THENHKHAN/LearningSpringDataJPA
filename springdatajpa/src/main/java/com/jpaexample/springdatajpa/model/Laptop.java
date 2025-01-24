package com.jpaexample.springdatajpa.model;


import jakarta.persistence.*;

@Entity
@Table(name = "jpa_laptops")
// referencing table. and Student table will be called referenced.
// table which contains the FK will be the referencing table and to whom it's referencing will be called referenced table.
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long laptopId;
    private String modelNumber;
    private String brand;

    // lets create student ref to get student info from laptop
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    //Here in Laptop, The @OneToOne relationship here does not use mappedBy, meaning that it is the owning side of the relationship.
//    @JoinColumn(name = "noor_studentEntity_id", referencedColumnName = "studentId") // this will be the FK COls
    @JoinColumn(name = "noor_studentEntity_id") // This foreign key will still reference the primary key column (studentId) of the Student table because the default behavior of JPA assumes the primary key of the referenced entity if referencedColumnName is omitted.

    // The @JoinColumn annotation specifies that the Laptop table will have the noor_studentEntity_id column, which acts as the foreign key referencing the id column of the Address table.
    private Student studentRefInLaptopEntityAsFK;// this is the ref variable by this we can get info of the Student Entity.


    @ManyToOne()


    // getter & setter
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public Long getLaptopId() {
        return laptopId;
    }

    public void setLaptopId(Long laptopId) {
        this.laptopId = laptopId;
    }

    public Student getStudentRefInLaptopEntityAsFK() {
        return studentRefInLaptopEntityAsFK;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "laptopId=" + laptopId +
                ", modelNumber='" + modelNumber + '\'' +
                ", brand='" + brand + '\'' +
                ", studentRefInLaptopEntityAsFK=" + studentRefInLaptopEntityAsFK +
                '}';
    }
}
