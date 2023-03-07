package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.util.Calendar.APRIL;
import static java.util.Calendar.NOVEMBER;

// Bean Configuration Class.
@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){ // We inject the student repo
        return args -> {

            Student mariam = new Student(
                    "Mariam",
                    LocalDate.of(2001, APRIL, 5),
                    "mariam@gmail.com"
            );

            Student alex = new Student(
                    "Alex",
                    LocalDate.of(1994, NOVEMBER, 17),
                    "Alex@gmail.com"
            );

            repository.saveAll( List.of(mariam, alex) );

        };
    }
}
