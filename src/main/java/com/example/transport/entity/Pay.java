package com.example.transport.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "payment")
public class Pay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String senderAccountId;
    private String recipientAccountId;
    private double amount;
    private String currency;
    private LocalDateTime timestamp;
}
