package com.example.demo.student

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import java.lang.IllegalStateException
import java.time.LocalDate
import java.time.Month

@Service
public class StudentService {

    private var studentRepository : StudentRepository ;

    @Autowired
    constructor(studentRepository: StudentRepository){
        this.studentRepository = studentRepository;
    }

    public fun getStudents(): List<Student> {
        return listOf(
            return studentRepository.findAll()
        );
    }

    fun addNewStudent(student: Student):Unit {
        var studentByEmail: Student? = studentRepository.findStudentByEmail(student.getEmail())

        if(studentByEmail == null) {
                throw  IllegalStateException("email taken")
            }
        studentRepository.save(student)
    }
}