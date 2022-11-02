package com.example.demo

import com.example.demo.student.Student
import com.example.demo.student.StudentController
import org.springframework.boot.Banner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DemoApplication

     fun main(args: Array<String>){
        runApplication<DemoApplication>(*args){
        }
    }


