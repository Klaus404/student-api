package com.example.demo.student

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository


@Repository
public interface StudentRepository:
    JpaRepository<Student, Long> {
    //Mai sus e long pt ca ala e tipul Id


    @Query("select s from Student s where upper(s.email) = upper(?1)")
    fun findStudentByEmail(email: String?): Student?

}