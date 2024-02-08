package com.infocert.schoolsystem.dto;

import lombok.Data;

@Data
public class StudentDTO {
    private Long id;
    private String name;
    private Long departmentId;
    private Long addressId;
}
