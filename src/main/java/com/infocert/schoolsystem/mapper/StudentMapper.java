package com.infocert.schoolsystem.mapper;

import com.infocert.schoolsystem.dto.StudentDTO;
import com.infocert.schoolsystem.model.Address;
import com.infocert.schoolsystem.model.Department;
import com.infocert.schoolsystem.model.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

public StudentDTO StudentToDTO(Student student){
    StudentDTO studentDTO = new StudentDTO();
    studentDTO.setId(student.getId());
    studentDTO.setName(student.getName());

    if(student.getDepartment() != null){
        studentDTO.setDepartmentId(student.getDepartment().getId());
    }

    if (student.getAddress() != null) {
        studentDTO.setAddressId(student.getAddress().getId());
    }

        return studentDTO;
    }
    public Student StudentToEntity(StudentDTO studentDTO){
        Student student = new Student();
        student.setId(studentDTO.getId());
        student.setName(studentDTO.getName());


        Long departmentId = studentDTO.getDepartmentId();
        if (departmentId != null) {
            Department department = new Department();
            department.setId(departmentId);
            student.setDepartment(department);
        }

        Long addressId = studentDTO.getAddressId();
        if (addressId != null) {
            Address address = new Address();
            address.setId(addressId);
            student.setAddress(address);
        }

        return student;
    }
}
