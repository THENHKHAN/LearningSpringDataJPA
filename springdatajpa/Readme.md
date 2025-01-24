### ONE-MANY Relationship: _[Readmore in model package Readme](src/main/java/com/jpaexample/springdatajpa/model/Readme.md)_
* **Determining Which Entity Contains the Foreign Key (FK)** <br>
      In JPA (Java Persistence API), the entity that owns the relationship typically contains the foreign key (FK). The owner of the relationship is the one that manages the association, and this is where the foreign key will be placed in the database table.

   * **One-to-Many Relationship:**<br>
In a `@OneToMany` relationship, the `foreign key will usually be placed in the Many side` (the table with the "many" entities). In your case, for the relationship between StudentInformation and Address, the foreign key is stored in the Address table (the "many" side).

   * **Many-to-One Relationship:**<br>
The `@ManyToOne` side is always the `"owned"` side of the relationship and contains the foreign key. So in your Address class, the @ManyToOne annotation indicates that Address is the "many" side, and the StudentInformation class is the "one" side. Therefore, the Address table will have the Student_id column that refers to the StudentInformation entity.

* **@JoinColumn vs. mappedBy:**<br>
Here’s how to think about when to use @JoinColumn and when to use mappedBy:
  * **@JoinColumn:** <br>
       * Use `@JoinColumn` in the entity that owns the relationship (i.e., the entity that contains the foreign key).
       * It specifies the column name for the foreign key.
       * In a @ManyToOne relationship, the foreign key is stored in the "many" side, so we use @JoinColumn in the Address class (since it has the foreign key to StudentInformation).
  * **mappedBy:** <br>
       * Use `mappedBy` on the inverse side of the relationship (i.e., the entity that does not contain the foreign key).
       * It tells Hibernate where the relationship is mapped on the other side.
       * In a `@OneToMany` relationship, the mappedBy attribute is used in the "one" side to refer to the field in the "many" side that owns the relationship.
       * For `example`, in StudentInformation, the @OneToMany(mappedBy = "ob") annotation tells Hibernate that the relationship is mapped on the Address side by the ob field (which represents the student in the Address entity).
```java
@Entity
@Table(name = "Student")
public class StudentInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int rollno;
    private String name;

    @OneToMany(mappedBy = "ob")  // Inverse side: Student is mapped by Address via 'ob' field
    private Set<Address> addresses;

    // Getter, setter, and constructors...
}

@Entity
@Table(name = "Address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String cityname;

    @ManyToOne
    @JoinColumn(name = "Student_id")  // "Student_id" is the FK in the Address table
    private StudentInformation ob;

    // Getter, setter, and constructors...
}

```
   * Important:
     * Since Address is the "many" side and contains the foreign key (i.e., Student_id), we use @JoinColumn in the Address class to define the foreign key column (Student_id).
