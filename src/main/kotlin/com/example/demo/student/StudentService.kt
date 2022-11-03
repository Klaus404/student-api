package com.example.demo.student

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import java.lang.IllegalStateException
import java.time.LocalDate
import java.time.Month
import java.util.*
import javax.transaction.Transactional


@Service
public class StudentService {

    fun <T> Optional<T>.unwrap(): T? = orElse(null)

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

        if(studentByEmail!=null) {
                throw  IllegalStateException("email taken")
            }
        studentRepository.save(student)
    }
    @Transactional
    fun updateStudent(studentId: Long,
                      name: String?,
                      email: String?){
        var student :Student? = studentRepository.findById(studentId).unwrap()
        if(student == null){
            throw IllegalStateException("Student with id $studentId does not exist")
        }

        if(name != null &&
                name.length >0 &&
                student.getName() != name){
            student.setName(name)
        }

        if(email != null &&
            email.length > 0 &&
            student.getEmail()!= email){
            var studentOptional = studentRepository.findStudentByEmail(email)
            if (studentOptional == null){
                student.setEmail(email)
            }
        }
    }

    public fun deleteStudent(studentId : Long){
        var exists = studentRepository.existsById(studentId)
        if(!exists){
            throw IllegalStateException("Student with id $studentId does not exist!")
        }
        else{
            studentRepository.deleteById(studentId)
        }
    }


}