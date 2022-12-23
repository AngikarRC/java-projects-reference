package com.revise.spboot.controller;

import com.revise.spboot.entity.Department;
import com.revise.spboot.exception.DepartmentNotFoundException;
import com.revise.spboot.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @MockBean
    private DepartmentService departmentService;

    @Autowired
    private MockMvc mockMvc;

    private Department department;


    @BeforeEach
    void setUp() {
        department = new Department(1l,"ECE",
                "Kochi","EC-001");

    }

    @Test
    void saveDepartment() throws Exception {
        Department inputDepartment = new Department("ECE","Kochi",
                "EC-001");

        Mockito.when(departmentService.saveDepartment(inputDepartment)).thenReturn(department);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/department").contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"departmentName\":\"ECE\",\n" +
                        "    \"departmentAddress\":\"Kochi\",\n" +
                        "    \"departmentCode\":\"EC-001\"\n" +
                        "}")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void fetchDepartmentByid() throws Exception {
        Mockito.when(departmentService.fetchDepartmentById(1l)).thenReturn(department);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/department/1").
                contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk());
    }
}