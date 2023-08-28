package com.example.libraryManagementSystem.repository;

import com.example.libraryManagementSystem.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

    Author findByEmail(String email);
}
