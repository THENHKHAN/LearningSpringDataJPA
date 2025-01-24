# JPA and Hibernate: One-to-Many Mapping Example

## JPA and Hibernate

### What is JPA (Java Persistence API)?

**JPA** (Java Persistence API) is a **specification** for object-relational mapping (ORM) in Java. It defines a standard for managing relational data in Java applications. JPA allows developers to map Java objects to database tables and provides ways to query and manage the data.

- **JPA** does not provide the actual implementation; it just defines how Java objects should be managed. Frameworks like **Hibernate**, **EclipseLink**, and **OpenJPA** implement JPA.

### What is Hibernate?

**Hibernate** is a **framework** and the most popular implementation of JPA. It provides the actual functionality for ORM, such as automatic table creation, object-relational mapping, query generation, and transaction management.

- Hibernate implements the JPA specification and makes database operations much easier by mapping Java objects to relational database tables without needing to write complex SQL queries.

### Key Differences Between JPA and Hibernate

| Feature               | JPA                              | Hibernate                           |
| --------------------- | --------------------------------- | ----------------------------------- |
| **Type**              | Specification                    | Framework (JPA implementation)     |
| **Functionality**     | Defines object-relational mapping rules | Provides actual functionality for ORM |
| **Query Language**    | JPQL (Java Persistence Query Language) | HQL (Hibernate Query Language), JPQL |
| **Persistence Context**| Defined by JPA                   | Hibernate provides its own context  |
| **Caching**           | Not defined by JPA               | Hibernate supports first-level and second-level caching |
| **Transaction Management** | JPA uses Java EE transactions or user-managed transactions | Hibernate provides transaction management support |

---

## Entities

### 1. **Student Entity**

The `Student` entity represents a student, and it has a **one-to-many** relationship with the `Address` entity. One student can have multiple addresses.

```java
import javax.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Address> addresses;
}
```


# JPA Annotations Explanation

This project uses Java Persistence API (JPA) annotations to manage the relationship between entities in the database. Below is a brief explanation of the key annotations used in the code.

## `@Entity`
- **Purpose**: Marks the class as a JPA entity.
- This annotation tells the Java Persistence API (JPA) that the class should be treated as an entity and mapped to a database table.

## `@Id`
- **Purpose**: Marks the primary key field of the entity.
- Every JPA entity must have a primary key, and this annotation identifies the field that will act as the primary key.

## `@GeneratedValue`
- **Purpose**: Specifies how the primary key value will be generated.
- Commonly used for auto-incrementing primary keys. This annotation informs JPA to automatically generate and assign a unique primary key value for each new record.

## `@OneToMany`
- **Purpose**: Defines a one-to-many relationship between two entities.
- In this case, one `Student` can have multiple `Address` records. This annotation establishes the relationship between `Student` and `Address`.

## `mappedBy = "student"`
- **Purpose**: Specifies the field in the related entity that owns the relationship.
- This tells Hibernate that the `Address` entity owns the relationship (i.e., it contains the foreign key pointing to `Student`), and the `Student` entity does not need to include a foreign key column.

## `cascade = CascadeType.ALL`
- **Purpose**: Specifies that all operations (e.g., `save`, `update`, `delete`) on the `Student` entity should be propagated to the associated `Address` entities.
- This means that when a `Student` is saved, updated, or deleted, the same operations will be applied to all related `Address` entities automatically.

---


### 2. **Address Entity**
The Address entity represents an address, and it is associated with one student. Multiple addresses can belong to one student. This Address entity only has two columns (id and street).
```java
import javax.persistence.*;
import lombok.Data;

@Entity
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
}
```

## `@ManyToOne`
- **Purpose**: Specifies the many-to-one relationship between two entities.
- In this case, many `Address` entities can be associated with one `Student` entity. This annotation defines the "many" side of the relationship (the `Address` entity), where multiple addresses belong to a single student.

## `@JoinColumn`
- **Purpose**: Specifies the foreign key column in the `Address` table that references the `Student` table.
- In this case, the foreign key column `student_id` in the `Address` table references the primary key of the `Student` table. This establishes the relationship between the `Address` and `Student` entities.

---

# Sample Tables in the Database

When the entities are persisted in the database, the following tables will be created:

## Student Table

| id  | name        |
|-----|-------------|
| 1   | John Doe    |
| 2   | Jane Smith  |

The `Student` table holds the details of the students.

## Address Table

| id  | street             | student_id |
|-----|--------------------|------------|
| 1   | 123 Elm Street     | 1          |
| 2   | 456 Oak Avenue     | 1          |
| 3   | 789 Pine Blvd      | 2          |

The `Address` table holds the address details. The `student_id` column is a foreign key that links to the `Student` table, establishing the relationship between the `Address` and `Student` entities.

The `Address` table consists of two columns: `id` and `street`, along with the foreign key `student_id` to associate each address with a specific student.


* **Student Table:** Holds basic student details with id as the primary key.
* **Address Table:** Contains address details along with a `student_id` column that` acts as the foreign key to the Student table`. This helps establish the many-to-one relationship where many addresses belong to one student.
