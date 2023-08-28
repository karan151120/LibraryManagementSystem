package com.example.libraryManagementSystem.service.serviceImpl;

import com.example.libraryManagementSystem.DTO.resposeDTO.AuthorResponseDto;
import com.example.libraryManagementSystem.DTO.resposeDTO.AuthorsOfAgeResponseDto;
import com.example.libraryManagementSystem.entity.Author;
import com.example.libraryManagementSystem.repository.AuthorRepository;
import com.example.libraryManagementSystem.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorRepository authorRepository;
    @Override
    public String addAuthor(Author author) {
        authorRepository.save(author);

        return "Author added";
    }

    @Override
    public AuthorResponseDto getAuthorByEmail(String email) {
        Author author = authorRepository.findByEmail(email);

        AuthorResponseDto authorResponseDto = new AuthorResponseDto();
        authorResponseDto.setName(author.getName());
        authorResponseDto.setAge(author.getAge());

        return authorResponseDto;
    }

    @Override
    public AuthorsOfAgeResponseDto getAuthorsByAge(int age) {
        List<Author> authorList;
        List<Author> authorAgeList = new ArrayList<>();

        authorList = authorRepository.findAll();
        for(int i=0; i<authorList.size(); i++) {
            if(authorList.get(i).getAge() == age) {
                authorAgeList.add(authorList.get(i));
            }
        }

        AuthorsOfAgeResponseDto authorsOfAgeResponseDto = new AuthorsOfAgeResponseDto();
        authorsOfAgeResponseDto.setAuthorAge(authorAgeList);

        return authorsOfAgeResponseDto;
    }
}
