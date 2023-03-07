package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/* The aim of this class is for accessing to DB, specifically when working with JPA.
*  We specify the class in 'JpaRepository' to use and the type to work upon.*/
// Repository annotation: This interface is responsible for data access.
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {}
