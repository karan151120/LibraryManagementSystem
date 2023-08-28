package com.example.libraryManagementSystem.controller;

import com.example.libraryManagementSystem.DTO.requestDTO.StudentRequestDTO;
import com.example.libraryManagementSystem.DTO.requestDTO.UpdateStudentMobileRequestDto;
import com.example.libraryManagementSystem.DTO.resposeDTO.StudentResponseDTO;
import com.example.libraryManagementSystem.DTO.resposeDTO.UpdateStudentMobileResponseDto;
import com.example.libraryManagementSystem.entity.Student;
import com.example.libraryManagementSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/add")
    public String addStudent(@RequestBody StudentRequestDTO studentRequestDTO) {
        return studentService.addStudent(studentRequestDTO);
    }

    @PutMapping("/updateMobile")
    public UpdateStudentMobileResponseDto updateStudentMobNo(@RequestBody UpdateStudentMobileRequestDto updateStudentMobileRequestDto) throws Exception {
        return studentService.updateStudentMobNo(updateStudentMobileRequestDto);
    }

    @GetMapping("/getStudent")
    public StudentResponseDTO getStudentById(@RequestParam("id")Integer id) {
        return studentService.getStudentById(id);
    }

    @GetMapping("/getAllStudents")
    public List<StudentResponseDTO> getAllStudents() {
        return studentService.getAllStudents();
    }
}
