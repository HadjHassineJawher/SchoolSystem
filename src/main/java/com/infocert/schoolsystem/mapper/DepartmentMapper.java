package com.infocert.schoolsystem.mapper;

import com.infocert.schoolsystem.dto.DepartmentDTO;
import com.infocert.schoolsystem.model.Department;
import com.infocert.schoolsystem.model.Student;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DepartmentMapper {
    public DepartmentDTO departmentToDTO(Department department) {
        DepartmentDTO departmentDTO = new DepartmentDTO();
        departmentDTO.setId(department.getId());
        departmentDTO.setName(department.getName());
        List<Long> studentIds = department.getStudents().stream().map(Student::getId).collect(Collectors.toList());

        departmentDTO.setStudentIds(studentIds);
        return departmentDTO;
    }

    public Department DepartmentToEntity(DepartmentDTO departmentDTO){
        Department department = new Department();
        department.setId(departmentDTO.getId());
        department.setName(departmentDTO.getName());

        return department;
    }

}
