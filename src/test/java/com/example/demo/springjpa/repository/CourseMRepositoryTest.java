package com.example.demo.springjpa.repository;

import com.example.demo.springjpa.entity.Course;
import com.example.demo.springjpa.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CourseMRepositoryTest {

    @Autowired
    private CourseMRepository courseMaterial;

    @Test
    public void savecourse(){
        Course course = Course.builder()
                .title("FOC")
                .credit(6)
                .build();
        CourseMaterial courseM = CourseMaterial.builder()
                .url("bitsathy.ac.in")
                .course(course)
                .build();
        courseMaterial.save(courseM);
    }
    @Test
    public void printallcm(){
        List<CourseMaterial>  CourseMaterials = courseMaterial.findAll();
        System.out.println(CourseMaterials);
    }

}