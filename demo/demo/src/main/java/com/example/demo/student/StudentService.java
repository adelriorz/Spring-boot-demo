package com.example.demo.student;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service /* With this we're telling 'StudentController' that this class is a JavaBean. */
public class StudentService {

    public List<Student> getStudents() {
        return List.of(
                new Student(
                        1L,
                        "Mariam",
                        21,
                        LocalDate.of(2000, Month.APRIL, 5),
                        "mariam@gmail.com"
                )
        );
    }
}