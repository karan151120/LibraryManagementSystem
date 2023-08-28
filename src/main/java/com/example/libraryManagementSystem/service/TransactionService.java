package com.example.libraryManagementSystem.service;

import com.example.libraryManagementSystem.DTO.requestDTO.IssueBookRequestDto;
import com.example.libraryManagementSystem.DTO.resposeDTO.IssueBookResponseDto;
import com.example.libraryManagementSystem.exception.BookNotFoundException;
import com.example.libraryManagementSystem.exception.CardNotFoundException;

public interface TransactionService {

    public IssueBookResponseDto issueBook(IssueBookRequestDto issueBookRequestDto) throws Exception;
}
