package com.example.libraryManagementSystem.service.serviceImpl;

import com.example.libraryManagementSystem.DTO.requestDTO.StudentRequestDTO;
import com.example.libraryManagementSystem.DTO.requestDTO.UpdateStudentMobileRequestDto;
import com.example.libraryManagementSystem.DTO.resposeDTO.CardResponseDto;
import com.example.libraryManagementSystem.DTO.resposeDTO.StudentResponseDTO;
import com.example.libraryManagementSystem.DTO.resposeDTO.UpdateStudentMobileResponseDto;
import com.example.libraryManagementSystem.entity.Card;
import com.example.libraryManagementSystem.entity.Student;
import com.example.libraryManagementSystem.enums.Status;
import com.example.libraryManagementSystem.exception.StudentNotFoundException;
import com.example.libraryManagementSystem.repository.StudentRepository;
import com.example.libraryManagementSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public String addStudent(StudentRequestDTO studentRequestDTO) {
        Student student = new Student();
        student.setName(studentRequestDTO.getName());
        student.setAge(studentRequestDTO.getAge());
        student.setDepartment(studentRequestDTO.getDepartment());
        student.setMobNo(studentRequestDTO.getMobNo());

        Card card = new Card();
        card.setStatus(Status.ACTIVE);
        card.setValidTill("2024-01-01");
        card.setStudent(student);

        student.setCard(card);
        studentRepository.save(student);

        return "Student added";
    }

    @Override
    public UpdateStudentMobileResponseDto updateStudentMobNo(UpdateStudentMobileRequestDto updateStudentMobileRequestDto) throws Exception {
        Student student;

        try{
            student = studentRepository.findById(updateStudentMobileRequestDto.getId()).get();
            student.setMobNo(updateStudentMobileRequestDto.getMobNo());
            Student updatedStudent = studentRepository.save(student);

            UpdateStudentMobileResponseDto updateStudentMobileResponseDto = new UpdateStudentMobileResponseDto();
            updateStudentMobileResponseDto.setName(updatedStudent.getName());
            updateStudentMobileResponseDto.setMobNo(updateStudentMobileRequestDto.getMobNo());

            return updateStudentMobileResponseDto;
        }
        catch (Exception e) {
            throw new StudentNotFoundException("Student id is Invalid");
        }
    }

    @Override
    public StudentResponseDTO getStudentById(int id) {
        Student student = studentRepository.findById(id).get();

        StudentResponseDTO studentResponseDTO = new StudentResponseDTO();
        studentResponseDTO.setId(student.getId());
        studentResponseDTO.setAge(student.getAge());
        studentResponseDTO.setDepartment(student.getDepartment());
        studentResponseDTO.setMobNo(student.getMobNo());
        studentResponseDTO.setName(student.getName());

        CardResponseDto cardResponseDto = new CardResponseDto();
        cardResponseDto.setIssueDate(student.getCard().getIssueDate());
        cardResponseDto.setStatus(student.getCard().getStatus());
        cardResponseDto.setUpdatedOn(student.getCard().getUpdatedOn());
        cardResponseDto.setValidTill(student.getCard().getValidTill());
        cardResponseDto.setId(student.getId());

        studentResponseDTO.setCardResponseDto(cardResponseDto);
        return studentResponseDTO;
    }

    @Override
    public List<StudentResponseDTO> getAllStudents() {
        List<StudentResponseDTO> allStudents = new ArrayList<>();

        List<Student> studentList = studentRepository.findAll();

        for(int i=0; i<studentList.size(); i++) {
            Student student = studentList.get(i);

            StudentResponseDTO studentResponseDTO = new StudentResponseDTO();
            studentResponseDTO.setId(student.getId());
            studentResponseDTO.setAge(student.getAge());
            studentResponseDTO.setDepartment(student.getDepartment());
            studentResponseDTO.setMobNo(student.getMobNo());
            studentResponseDTO.setName(student.getName());

            CardResponseDto cardResponseDto = new CardResponseDto();
            cardResponseDto.setIssueDate(student.getCard().getIssueDate());
            cardResponseDto.setStatus(student.getCard().getStatus());
            cardResponseDto.setUpdatedOn(student.getCard().getUpdatedOn());
            cardResponseDto.setValidTill(student.getCard().getValidTill());
            cardResponseDto.setId(student.getId());

            studentResponseDTO.setCardResponseDto(cardResponseDto);
            allStudents.add(studentResponseDTO);
        }

        return allStudents;
    }
}
