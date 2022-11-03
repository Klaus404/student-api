package com.example.demo.student

import java.time.LocalDate
import java.time.Month
import java.time.Period
import javax.persistence.*
import kotlin.jvm.Transient

@Entity
@Table
class Student {
    @Id
    @SequenceGenerator(
        name = "student_sequence",
        sequenceName = "student_sequence",
        allocationSize = 1
        )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "student_sequence"
    )
    private var id: Long = 0;
    private var name : String? = "";
    private var email : String? = "";
    private var dob = LocalDate.of(1900, Month.APRIL, 12)
    @Transient
    private var age = 0;

    constructor(){

    }

    constructor(id: Long, name: String,
                email:String, dob:LocalDate){
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
    }
    constructor( name: String,
                email:String, dob:LocalDate,
                ){
        this.name = name;
        this.email = email;
        this.dob = dob;

    }


    public fun getId(): Long{
        return id;
    }

    public fun setId( id: Long){
        this.id = id;
    }

    public fun getName(): String?{
        return name;
    }

    public fun setName( name : String?){
        this.name = name;
    }

    public fun getEmail(): String?{
        return email;
    }

    public fun setEmail( email: String?){
        this.email = email;
    }

    public fun getDob(): LocalDate{
        return dob;
    }

    public fun setDob( dob: LocalDate){
        this.dob = dob;
    }

    public fun getAge(): Int{
        return Period.between(this.dob, LocalDate.now()).years;
    }

    public fun setAge( age: Int){
        this.age = age;
    }

    override fun toString(): String {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", age=" + age +
                '}';
    }


}