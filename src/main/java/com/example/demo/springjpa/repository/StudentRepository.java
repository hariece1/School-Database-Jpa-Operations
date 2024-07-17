package com.example.demo.springjpa.repository;


import com.example.demo.springjpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    public List<Student> findByname(String name);
    public List<Student> findBynameContaining(String name);
    public List<Student> findBynameNotNull();
    public List<Student> findByGuardianName(String guardianName);//Same like name containing method in test
  //Refer docs for more methods by jpa

    //JPQL-Java persistence Query Language
    //JPQL is based on classes created on tables
        @Query("select s from Student s where s.mailid= ?1")
        Student getStudentByEmailid(String mailid);


//        //Native sql query to retrive data from db
//        @Query(
//                value = "select * from Student s where s.mailid = ?1",
//                nativeQuery = true
//        )
//        Student getStudentByEmailidnative(String mailid);
@Query(
        value = "select * from Student s where s.mailid = ?1",
        nativeQuery = true
)
Student getStudentByEmailidnative(String mailid);

}
