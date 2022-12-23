package com.revise.spboot.service;

import com.revise.spboot.entity.Department;
import com.revise.spboot.exception.DepartmentNotFoundException;
import com.revise.spboot.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    @Autowired
    DepartmentRepository departmentRepository;
    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException {
         Optional<Department> department =  departmentRepository.findById(departmentId);
         if(!department.isPresent()){
            throw new DepartmentNotFoundException("Department Not Available!");
         }

         return department.get();
    }

    @Override
    public void deleteDepById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepById(Long departmentId, Department department) {
        Department depFromDB = departmentRepository.findById(departmentId).get();
        if(Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())){
            depFromDB.setDepartmentName(department.getDepartmentName());
        }
        if(Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())){
            depFromDB.setDepartmentAddress(department.getDepartmentAddress());
        }
        if(Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())){
            depFromDB.setDepartmentCode(department.getDepartmentCode());
        }

        return departmentRepository.save(depFromDB);
    }

    @Override
    public Department findDeptByName(String departnameName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(departnameName);
    }

}
