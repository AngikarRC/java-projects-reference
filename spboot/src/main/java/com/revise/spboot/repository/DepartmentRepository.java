package com.revise.spboot.repository;

import com.revise.spboot.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {

    Department findByDepartmentNameIgnoreCase(String departnameName);
}
