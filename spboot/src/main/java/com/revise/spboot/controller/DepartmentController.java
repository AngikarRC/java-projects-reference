package com.revise.spboot.controller;

import com.revise.spboot.entity.Department;
import com.revise.spboot.exception.DepartmentNotFoundException;
import com.revise.spboot.service.DepartmentService;
import com.revise.spboot.service.DepartmentServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("api/department")
    public Department saveDepartment(@Valid @RequestBody Department department){
        LOGGER.info("Inside saveDepartment api");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("api/departments")
    public List<Department> fetchAllDepartments(){
        return departmentService.fetchAllDepartments();
    }

    @GetMapping("api/department/{id}")
    public Department fetchDepartmentByid(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        return departmentService.fetchDepartmentById(departmentId);
    }

    @DeleteMapping("api/department/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
        departmentService.deleteDepById(departmentId);
        return "Department deleted successfully";
    }

    @PutMapping("api/department/{id}")
    public Department updateDepartmentByid(@PathVariable("id") Long departmentId, @RequestBody Department department){
        LOGGER.info("Inside updateDepartmentByID API");
        return departmentService.updateDepById(departmentId , department);
    }

    @GetMapping("api/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departnameName){
        return departmentService.findDeptByName(departnameName);
    }

}
