package com.example.libraryManagementSystem.service;

import com.example.libraryManagementSystem.DTO.requestDTO.StudentRequestDTO;
import com.example.libraryManagementSystem.DTO.requestDTO.UpdateStudentMobileRequestDto;
import com.example.libraryManagementSystem.DTO.resposeDTO.StudentResponseDTO;
import com.example.libraryManagementSystem.DTO.resposeDTO.UpdateStudentMobileResponseDto;
import com.example.libraryManagementSystem.entity.Student;

import java.util.List;

public interface StudentService {

    public String addStudent(StudentRequestDTO studentRequestDTO);

    public UpdateStudentMobileResponseDto updateStudentMobNo(UpdateStudentMobileRequestDto updateStudentMobileRequestDto) throws Exception;

    public StudentResponseDTO getStudentById(int id);

    public List<StudentResponseDTO> getAllStudents();
}
