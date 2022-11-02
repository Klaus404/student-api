package com.example.demo.student

import org.springframework.context.annotation.Configuration
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import java.time.LocalDate
import java.time.Month

@Configuration
class StudentConfig {

    @Bean
     fun init(repository: StudentRepository) = CommandLineRunner{
        var mariam = Student(

                "Mariam",
                "mariam@jamal.com",
                LocalDate.of(2000, Month.APRIL, 12),
            )

        var alex = Student(
            "Alex",
            "alex@jamal.com",
            LocalDate.of(2004, Month.APRIL, 12),
        )

        repository.saveAll(
            listOf<Student>(mariam, alex)
        )
    }

}