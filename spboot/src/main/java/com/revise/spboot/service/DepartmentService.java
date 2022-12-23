package com.revise.spboot.service;

import com.revise.spboot.entity.Department;
import com.revise.spboot.exception.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);

    List<Department> fetchAllDepartments();

    Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;

    void deleteDepById(Long departmentId);

    Department updateDepById(Long departmentId, Department department);

    Department findDeptByName(String departnameName);
}
