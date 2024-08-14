package com.project.uber.uberApp.entities;

import com.project.uber.uberApp.entities.enums.TransactionMethod;
import com.project.uber.uberApp.entities.enums.TransactionType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class WalletTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double amount;
    @ManyToOne
    private Wallet wallet;
    private TransactionMethod transactionMethod;
    private TransactionType transactionType;
    @OneToOne
    private Ride ride;
    private String transactionId;
    @CreationTimestamp
    private LocalDateTime timestamp;

}
