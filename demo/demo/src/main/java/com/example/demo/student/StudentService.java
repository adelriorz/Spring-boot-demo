package com.example.demo.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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
        Optional<Student> studentOptional = studentRepository.findStudentsByEmail(student.getEmail());
        if(studentOptional.isPresent()){
            throw new IllegalStateException("This email already exists.");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId){
        boolean exists = studentRepository.existsById(studentId);
        if(!exists){
            throw new IllegalStateException("Student with Id " + studentId + " does not exist.");
        } else {
            studentRepository.deleteById(studentId);
        }
    }

    @Transactional // By using it, we don't need to implement any PQL Query. Goes into a managed state.
    public void updateStudent(Long studentId, String name, String email){
        Student student = studentRepository.findById(studentId)
            .orElseThrow(() -> new IllegalStateException(
                    "Student with Id " + studentId + " does not exist."
            ));

        if(name != null && !Objects.equals(student.getName(), name)) student.setName(name);

        if(email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)){
            Optional<Student> studentOptional = studentRepository.findStudentsByEmail(email);
            if(studentOptional.isPresent()){
                throw new IllegalStateException("This email already exists.");
            }
            student.setEmail(email);
        }

    }

}