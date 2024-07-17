package com.example.demo.springjpa.repository;

import com.example.demo.springjpa.entity.Course;
import com.example.demo.springjpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveteacher(){
        Course course = Course.builder()
                .title("DBMS")
                .credit(5)
                .build();


        Teacher teacher = Teacher.builder()
                        .firstName("Mani")
                        .lastName("Kandan")

                //.c(List.of(course))
                        .build();
        teacherRepository.save(teacher);
    }

    public void printall(){
        List<Teacher> teachers = teacherRepository.findAll();
        System.out.println(teachers);
    }
}