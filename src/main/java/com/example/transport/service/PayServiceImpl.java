package com.example.transport.service;

import com.example.transport.dto.PayRequestDto;
import com.example.transport.dto.PayResponseDto;

import java.util.List;

public interface PayServiceImpl {
    List<PayResponseDto> findAll();

    PayResponseDto getPayById(Long id);

    void createPay(PayRequestDto payRequestDto);

    void update(Long id, PayRequestDto payRequestDto);

    void delete(Long id);
}
