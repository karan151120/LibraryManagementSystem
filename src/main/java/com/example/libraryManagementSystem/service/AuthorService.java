package com.example.libraryManagementSystem.service;

import com.example.libraryManagementSystem.DTO.resposeDTO.AuthorResponseDto;
import com.example.libraryManagementSystem.DTO.resposeDTO.AuthorsOfAgeResponseDto;
import com.example.libraryManagementSystem.entity.Author;

public interface AuthorService {

    public String addAuthor(Author author);

    public AuthorResponseDto getAuthorByEmail(String email);

    public AuthorsOfAgeResponseDto getAuthorsByAge(int age);
}
