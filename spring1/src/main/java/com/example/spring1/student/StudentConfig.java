package com.example.spring1.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args ->{
        Student ashi=new Student(
            "Ashi",
            "ashi@gmial.com",
            LocalDate.of(2000,Month.JANUARY,5),
            21

        );
        Student khushi=new Student(
            "Khushi",
            "khushi@gmial.com",
            LocalDate.of(2000,Month.JANUARY,5),
            21

        );
        repository.saveAll(
            List.of(ashi,khushi)
        );
        };
    }
}
