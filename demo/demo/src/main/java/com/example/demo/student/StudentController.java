package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
@RestController // Allows to create REST apps.
@RequestMapping(path = "/api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    /* Using Autowired so 'studentService' will be instanced for us and injected into the constructor. BUT
     * We need the 'StudentService' class to be a Bean/Service, so it can be instanced.
     */
    public StudentController(StudentService studentService){
        this.studentService = studentService; // not using 'new' keyword because we're using dependency injection.
    }

    /*The method GetMapping allows us to create an endpoint, instead of the 'Whitelabel'. This route
     * will redirect to the JSON given. It's important to define the route ("/").
     * This method goes in the 'StudentService' class as we try to encapsulate as much as we can*/
    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents(); // We are using the N-tier design pattern.
    }
}
