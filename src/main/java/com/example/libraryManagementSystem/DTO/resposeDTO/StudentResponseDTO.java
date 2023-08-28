package com.example.libraryManagementSystem.DTO.resposeDTO;

import com.example.libraryManagementSystem.entity.Card;
import com.example.libraryManagementSystem.enums.Department;
import jakarta.persistence.CascadeType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentResponseDTO {

    private int id;

    private String name;

    private int age;

    private Department department;

    private String mobNo;

    CardResponseDto cardResponseDto;
}
