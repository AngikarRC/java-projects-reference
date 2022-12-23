package com.revise.spboot.service;

import com.revise.spboot.entity.Department;
import com.revise.spboot.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    DepartmentService departmentService;

    @MockBean
    DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department =
                new Department(1l,"maths","kolkata","M-01");

        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("maths"))
                .thenReturn(department);
    }

    @Test
    @DisplayName("Get Data based on valid department name")
    public void whenValidDepartmentname_departmentShouldFound(){
        String departmentName = "maths";

        Department isItFound = departmentService.findDeptByName(departmentName);

        assertEquals(departmentName,isItFound.getDepartmentName());
    }
}