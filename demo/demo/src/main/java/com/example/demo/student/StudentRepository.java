package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/* The aim of this class is for accessing to DB, specifically when working with JPA.
*  We specify the class in 'JpaRepository' to use and the type to work upon.*/
// Repository annotation: This interface is responsible for data access.
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    // SELECT * FROM student WHERE email = ? // Same syntax
//    @Query("SELECT s FROM Student s WHERE s.email = ?1") // Equivalent
    Optional<Student> findStudentsByEmail(String email);

}
