package com.ndhaniff.demo.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {

  @Bean
  CommandLineRunner commandLineRunner(StudentRepository repository) {
    // lambda / closure / callback
    return args -> {
      Student mariam = new Student("Mariam", LocalDate.of(2000, Month.MARCH, 30), "mariam@jamal.com");
      Student alex = new Student("Alex", LocalDate.of(2001, Month.MARCH, 30), "alex@gmail.com");

      repository.saveAll(List.of(mariam, alex));
    };
  }
}