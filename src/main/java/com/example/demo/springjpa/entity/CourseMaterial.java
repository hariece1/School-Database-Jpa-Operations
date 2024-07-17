package com.example.demo.springjpa.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "course")//AS if we are using lazy fetch for course materail we need exclude course from this
public class CourseMaterial {
    @Id
    @SequenceGenerator(
            name = "courseMaterialId_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "courseMaterialId_sequence"
    )
    private Long courseMaterialId;
    private String url;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER//Eager and lazy fectching difference is if you have tow tables
            //Eager bring two data table lazy bring one data table untill or unless you mention to bring
         //   optional = false //this means when ever we creating course we need to create to course too.
    )
    @JoinColumn(
            name="course_id",
            referencedColumnName = "courseId"
    )
    private Course course;


}
