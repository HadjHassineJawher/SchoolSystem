package com.infocert.schoolsystem.controller;

import com.infocert.schoolsystem.dto.AddressDTO;
import com.infocert.schoolsystem.dto.StudentDTO;
import com.infocert.schoolsystem.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/addStudent")
    public ResponseEntity<StudentDTO> addStudent(@RequestBody StudentDTO studentDTO){
        StudentDTO createStudent = studentService.createStudent(studentDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createStudent);
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable Long studentId){
        StudentDTO studentDTO = studentService.findStudentById(studentId);
        return ResponseEntity.ok(studentDTO);
    }

    @PostMapping("/{studentId}/address")
    public ResponseEntity<StudentDTO> addAdressToStudent(@PathVariable Long studentId, @RequestBody AddressDTO addressDTO){
        StudentDTO updatedStudent = studentService.addAddressToStudent(studentId,addressDTO);
        return ResponseEntity.ok(updatedStudent);
    }

}
