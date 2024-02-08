package com.infocert.schoolsystem.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(value = {"studentIds"})
public class DepartmentDTO {
    private Long id;
    private String name;
    private List<Long> studentIds;
}
