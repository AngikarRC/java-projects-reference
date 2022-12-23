package com.spring.datajpa.springdatajpatutorial.entity.repository;

import com.spring.datajpa.springdatajpatutorial.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {
}
