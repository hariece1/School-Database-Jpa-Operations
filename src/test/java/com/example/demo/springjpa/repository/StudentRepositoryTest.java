package com.example.demo.springjpa.repository;

import com.example.demo.springjpa.entity.Guardian;
import com.example.demo.springjpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest // standard testing
//  @DataJpaTest //Helps to test repository layer database not be impacted
class StudentRepositoryTest {

    //creating object
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        //builder in student entity to create object we not store student id as auto generated
        Student student = Student.builder()
                .mailid("hari@gmail.com")
                .name("hari")
//               .guardian("guard")  shows error because changed class embedded so.
//                .guardianmail("guard@gmail")
//                .phone("1234124123")
                .build();
        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGaurd(){
        Guardian guardian = Guardian.builder()
                .name("guard")  //shows error because changed class embedded so.
                .guardianmail("guard@gmail")
                .phone("1234124123")
                .build();
        Student student = Student.builder()
                .mailid("hari@gmail.com")
                .name("hari")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
    }

    @Test
    public void printallstudents(){
        List<Student> studentList = studentRepository.findAll();
        System.out.println("Studentlist = " + studentList);
    }
    @Test
     public void printstudentbyname(){
        List<Student> student = studentRepository.findByname("hari");
        System.out.println(student);
     }
    @Test
    public void printstudentbynameContaining(){
        List<Student> student = studentRepository.findBynameContaining("ha");
        System.out.println(student);
    }

    @Test
    public void getStudentByEmailid(String mailid){
        Student student = studentRepository.getStudentByEmailid("hari@gmail.com");
        System.out.println(student);
    }
//    @Test
//    public void getStudentByEmailidnative(String mailid){
//        Student student = studentRepository.getStudentByEmailidnative("hari@gmail.com");
//        System.out.println(student);
//    }

//    @Test
//    public void getStudentByEmailidnative(String EmailId) {
//        Student student = studentRepository.getStudentByEmailidnative(EmailId);
//        System.out.println(student);
//    }

}