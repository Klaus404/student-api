package com.example.demo.student

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate
import java.time.Month

@RestController
@RequestMapping("api/v1/student")
public class StudentController {

    private val studentService: StudentService;

    @Autowired //TODO: Studiaza chestia asta cu autowired ce face pereche cu Component/Service din StudentService
    constructor(studentService: StudentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public fun getStudents(): List<Student> {
        return studentService.getStudents()
    }

    @PostMapping
    public fun registerNewStudent(@RequestBody student: Student){
        studentService.addNewStudent(student)
    }

    @DeleteMapping("{studentId}")
    public fun deleteStudent(
        @PathVariable("studentId") studentId : Long){
        studentService.deleteStudent(studentId);
    }

    @PutMapping("{studentId}")
    public fun updateStudent(
        @PathVariable("studentId") studentId: Long,
        @RequestParam(required = false) name: String?,
        @RequestParam(required = false) email: String?
    ){
        studentService.updateStudent(studentId, name, email)
    }
}

