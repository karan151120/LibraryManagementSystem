package com.example.libraryManagementSystem.controller;

import com.example.libraryManagementSystem.DTO.requestDTO.IssueBookRequestDto;
import com.example.libraryManagementSystem.DTO.resposeDTO.IssueBookResponseDto;
import com.example.libraryManagementSystem.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @GetMapping("/issueBook")
    public IssueBookResponseDto issueBook(IssueBookRequestDto issueBookRequestDto) throws Exception {
        return transactionService.issueBook(issueBookRequestDto);
    }
}
