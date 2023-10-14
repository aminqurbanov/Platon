package com.example.transport.dto;

import lombok.Data;

@Data
public class PayResponseDto {
   private Long id;
   private String senderAccountId;
   private String recipientAccountId;
   private double amount;
   private String currency;
}
