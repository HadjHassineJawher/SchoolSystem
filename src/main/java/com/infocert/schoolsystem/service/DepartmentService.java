package com.infocert.schoolsystem.service;

import com.infocert.schoolsystem.dto.DepartmentDTO;
import com.infocert.schoolsystem.mapper.DepartmentMapper;
import com.infocert.schoolsystem.model.Department;
import com.infocert.schoolsystem.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;

    public DepartmentService(DepartmentRepository departmentRepository, DepartmentMapper departmentMapper) {
        this.departmentRepository = departmentRepository;
        this.departmentMapper = departmentMapper;
    }

    public DepartmentDTO createDepartment (DepartmentDTO departmentDTO){
        Department department = departmentMapper.DepartmentToEntity(departmentDTO);
        department = departmentRepository.save(department);
        return departmentMapper.departmentToDTO(department);
    }

    public List<DepartmentDTO> getAllDepartments() {
        return departmentRepository.findAll().stream().map(departmentMapper::departmentToDTO).collect(Collectors.toList());
    }
}
