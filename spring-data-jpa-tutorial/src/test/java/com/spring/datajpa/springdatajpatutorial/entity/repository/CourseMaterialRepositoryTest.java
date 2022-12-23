package com.spring.datajpa.springdatajpatutorial.entity.repository;

import com.spring.datajpa.springdatajpatutorial.entity.Course;
import com.spring.datajpa.springdatajpatutorial.entity.Coursematerial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository repository;

    @Test
    public void saveCourseMaterial(){
        Course course = Course.builder()
                .title("DSA")
                .credit(5)
                .build();

        Coursematerial coursematerial = Coursematerial.builder()
                .url("www.google.com")
                .course(course).build();

        repository.save(coursematerial);
    }
    @Test
    public void printAllCourseMaterials(){
        List<Coursematerial> coursematerialList = repository.findAll();
        System.out.println("Coursematerials :"+coursematerialList);

    }

}