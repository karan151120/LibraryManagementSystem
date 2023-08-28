package com.example.libraryManagementSystem.DTO.resposeDTO;

import com.example.libraryManagementSystem.enums.TransactionStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class IssueBookResponseDto {
    private String transactionNumber;

    private TransactionStatus transactionStatus;

    private String bookName;
}
