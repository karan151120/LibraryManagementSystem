package com.example.libraryManagementSystem.controller;

import com.example.libraryManagementSystem.DTO.resposeDTO.AuthorResponseDto;
import com.example.libraryManagementSystem.DTO.resposeDTO.AuthorsOfAgeResponseDto;
import com.example.libraryManagementSystem.entity.Author;
import com.example.libraryManagementSystem.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @PostMapping("/add")
    public String addAuthor(@RequestBody Author author) {
        return authorService.addAuthor(author);
    }

    @GetMapping("/getByEmail")
    public AuthorResponseDto getAuthorByEmail(@RequestParam("email")String email) {
        return authorService.getAuthorByEmail(email);
    }

    @GetMapping("/getAuthorOfAge")
    public AuthorsOfAgeResponseDto getAuthorsByAge(@RequestParam("age")Integer age) {
        return authorService.getAuthorsByAge(age);
    }
}
