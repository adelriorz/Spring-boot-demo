package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping // Retrieving students from DB
    public List<Student> getStudents(){
        return studentService.getStudents(); // We are using the N-tier design pattern.
    }

    @PostMapping // Retrieve student that comes from the client
    public void registerNewStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(
            @PathVariable("studentId") Long studentId){
        studentService.deleteStudent(studentId);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(@PathVariable("studentId") Long studentId,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String email){
        studentService.updateStudent(studentId, name, email);
    }

}
