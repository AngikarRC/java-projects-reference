package com.spring.datajpa.springdatajpatutorial.entity.repository;

import com.spring.datajpa.springdatajpatutorial.entity.Course;
import com.spring.datajpa.springdatajpatutorial.entity.Teacher;
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
    public void saveTeacherWithCourses() {
        Course courseDSA = Course.builder().
                title("DSA").
                credit(5)
                .build();

        Course courseJAVA = Course.builder().
                title("Java").
                credit(4)
                .build();

        Teacher teacher = Teacher.builder().
                firstName("Shashanka").
                lastName("Dayal").
                courses(List.of(courseDSA, courseJAVA)).
                build();

        teacherRepository.save(teacher);
    }
}