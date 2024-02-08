package com.infocert.schoolsystem.service;

import com.infocert.schoolsystem.dto.AddressDTO;
import com.infocert.schoolsystem.dto.StudentDTO;
import com.infocert.schoolsystem.mapper.StudentMapper;
import com.infocert.schoolsystem.model.Address;
import com.infocert.schoolsystem.model.Student;
import com.infocert.schoolsystem.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    public StudentDTO createStudent(StudentDTO studentDTO) {
        Student student = studentMapper.StudentToEntity(studentDTO);
        student = studentRepository.save(student);
        return studentMapper.StudentToDTO(student);
    }


    public StudentDTO findStudentById(Long studentId) {

        return studentRepository.findStudentById(studentId)
                .map(studentMapper::StudentToDTO)
                .orElseThrow(() -> new NoSuchElementException("Student with ID " + studentId + " does not exist !"));
    }

    public StudentDTO addAddressToStudent(Long studentId, AddressDTO addressDTO) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new NoSuchElementException("Student not found with ID: " + studentId));

        Address address = new Address();
        address.setCountry(addressDTO.getCountry());
        address.setCity(addressDTO.getCity());
        address.setStreet(addressDTO.getStreet());
        address.setHouseNumber(addressDTO.getHouseNumber());
        address.setPostalCode(addressDTO.getPostalCode());

        student.setAddress(address);

        // Save the student entity, cascading will persist the associated address
        student = studentRepository.save(student);

        return studentMapper.StudentToDTO(student);
    }
}
