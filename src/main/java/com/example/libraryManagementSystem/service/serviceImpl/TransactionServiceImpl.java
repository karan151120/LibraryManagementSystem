package com.example.libraryManagementSystem.service.serviceImpl;

import com.example.libraryManagementSystem.DTO.requestDTO.IssueBookRequestDto;
import com.example.libraryManagementSystem.DTO.resposeDTO.IssueBookResponseDto;
import com.example.libraryManagementSystem.entity.Book;
import com.example.libraryManagementSystem.entity.Card;
import com.example.libraryManagementSystem.entity.Transaction;
import com.example.libraryManagementSystem.enums.Status;
import com.example.libraryManagementSystem.enums.TransactionStatus;
import com.example.libraryManagementSystem.exception.BookNotFoundException;
import com.example.libraryManagementSystem.exception.CardNotFoundException;
import com.example.libraryManagementSystem.repository.BookRepository;
import com.example.libraryManagementSystem.repository.CardRepository;
import com.example.libraryManagementSystem.repository.TransactionRepository;
import com.example.libraryManagementSystem.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    CardRepository cardRepository;

    @Autowired
    TransactionRepository transactionRepository;


    @Override
    public IssueBookResponseDto issueBook(IssueBookRequestDto issueBookRequestDto) throws Exception {
        Transaction transaction = new Transaction();
        transaction.setTransactionNumber(String.valueOf(UUID.randomUUID()));
        transaction.setIssueOperation(true);

        Card card;

        try{
            card = cardRepository.findById(issueBookRequestDto.getCardId()).get();
        }
        catch (Exception e) {
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new CardNotFoundException("Card id is invalid");
        }

        transaction.setCard(card);

        Book book;

        try{
            book = bookRepository.findById(issueBookRequestDto.getBookId()).get();
        }
        catch (Exception e) {
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new BookNotFoundException("Book id is invalid");
        }

        transaction.setBook(book);

        if(card.getStatus() != Status.ACTIVE) {
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Card is not active");
        }

        if(book.isIssued()) {
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Book is already issued to other card");
        }

        transaction.setTransactionStatus(TransactionStatus.SUCCESS);
        book.setIssued(true);
        book.setCard(card);

        book.getTransactionList().add(transaction);

        card.getBookList().add(book);
        card.getTransactionList().add(transaction);

        cardRepository.save(card); // save card, book and transaction

        IssueBookResponseDto issueBookResponseDto = new IssueBookResponseDto();

        issueBookResponseDto.setBookName(book.getTitle());
        issueBookResponseDto.setTransactionNumber(transaction.getTransactionNumber());
        issueBookResponseDto.setTransactionStatus(transaction.getTransactionStatus());

        return issueBookResponseDto;
    }
}
