package com.example.demo.springjpa.repository;

import com.example.demo.springjpa.entity.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseMRepository extends JpaRepository<CourseMaterial,Long> {


}
