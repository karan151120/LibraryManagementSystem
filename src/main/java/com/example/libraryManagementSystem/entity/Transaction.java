package com.example.libraryManagementSystem.entity;

import com.example.libraryManagementSystem.enums.TransactionStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "transaction")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private TransactionStatus transactionStatus;

    private String transactionNumber;

    @CreationTimestamp
    private Date transactionDate;

    private boolean isIssueOperation;

    @ManyToOne
    @JoinColumn
    Card card;

    @ManyToOne
    @JoinColumn
    Book book;

}
