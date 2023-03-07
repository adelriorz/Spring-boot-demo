package com.example.demo.student;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Entity // For Hibernate
@Table // For the Table in our DB
public class Student {

    @Id // Specifies the primary key of an entity.
    /*
    * Defines a primary key generator that may be referenced by name when a generator element
    * is specified for the GeneratedValue annotation. A sequence generator may be specified
    *  on the entity class or on the primary key field or property.
    * The scope of the generator name is global to the persistence unit (across all generator types).
    * */
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )

    // Provides for the specification of generation strategies for the values of primary keys.
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE, // Recommended for Postgres
            generator = "student_sequence"
    )

    private Long id;
    private String name;

    @Transient // Specifies that the property or field is not persistent.
    private Integer age;
    private LocalDate dateOfBirth;
    private String email;

    public Student(){}
    public Student(Long id, String name, LocalDate dateOfBirth, String email) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
    }

    public Student(String name, LocalDate dateOfBirth, String email) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return Period.between(this.dateOfBirth, LocalDate.now()).getYears();
    } // Years will be calculated on real time instead of being storage.

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{\n" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", dateOfBirth=" + dateOfBirth +
                ", email='" + email + '\'' +
                '}';
    }

}
