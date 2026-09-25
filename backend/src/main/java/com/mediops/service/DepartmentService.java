package com.mediops.service;

import com.mediops.entity.Department;
import com.mediops.repository.DepartmentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.mediops.exception.ResourceNotFoundException;

import java.util.List;

@Service
@Transactional
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public Department create(Department department){
        return departmentRepository.save(department);
    }

    @Transactional(readOnly = true)
    public List<Department> getAll(){
        return departmentRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Department getById(Long id){
        return departmentRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Department not found with id: "+ id));
    }

    public Department update(Department department){
        return departmentRepository.save(department);
    }

    public void delete(Long id){
        departmentRepository.deleteById(id);
    }
}
