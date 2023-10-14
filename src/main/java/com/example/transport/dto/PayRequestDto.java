package com.example.transport.dto;

import lombok.Data;

@Data
public class PayRequestDto {
    private String model;
    private String senderAccountId;
    private String recipientAccountId;
    private double amount;
    private String currency;
}
