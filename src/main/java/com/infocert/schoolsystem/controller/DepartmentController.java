package com.infocert.schoolsystem.controller;

import com.infocert.schoolsystem.dto.DepartmentDTO;
import com.infocert.schoolsystem.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/addDepartment")
    public ResponseEntity<DepartmentDTO> addDepartment (@RequestBody DepartmentDTO departmentDTO){
        DepartmentDTO createDepartment = departmentService.createDepartment(departmentDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createDepartment);
    }

    @GetMapping("allDepartments")
    public ResponseEntity<List<DepartmentDTO>> getAllDepartments(){
        List<DepartmentDTO> departments = departmentService.getAllDepartments();
        return ResponseEntity.ok(departments);
    }
}
