package com.example.libraryManagementSystem.DTO.requestDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UpdateStudentMobileRequestDto {

    private int id;

    private String mobNo;
}
