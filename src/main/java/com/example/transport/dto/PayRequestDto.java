package com.example.transport.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PayRequestDto {

    private Long transactionId;

    private LocalDateTime timestamp;

    private String senderAccountId;

    private String recipientAccountId;

    private double amount;

    private String currency;
}
