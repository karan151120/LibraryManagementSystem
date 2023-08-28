package com.example.libraryManagementSystem.DTO.resposeDTO;

import com.example.libraryManagementSystem.enums.Status;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CardResponseDto {
    private int id;

    private Date issueDate;

    private Date updatedOn;

    private Status status;

    private String validTill;
}
