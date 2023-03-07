package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service /* With this we're telling 'StudentController' that this class is a JavaBean. */
public class StudentService {

    private final StudentRepository studentRepository; // Instance of the interface

    @Autowired // Important to annotate again, autowired.
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        student.toString();
    }
}