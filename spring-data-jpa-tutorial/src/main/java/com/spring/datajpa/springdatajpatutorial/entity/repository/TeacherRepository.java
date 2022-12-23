package com.spring.datajpa.springdatajpatutorial.entity.repository;

import com.spring.datajpa.springdatajpatutorial.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long> {
}
