package com.example.demo.springjpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Teacher {
    @Id
    @SequenceGenerator(
            name = "teacher_sequence",
            sequenceName = "teacher_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "teacher_sequence"
    )
    private Long teacherId;
    private String firstName;
    private String lastName;
   //Uni directional One to many mapping
    /*@OneToMany(
         cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "teacher_id",//It creates column in course table with name teacher id
            referencedColumnName = "teacherId"
    )
    private List<Course> courses;*/

}
