package com.example.transport.controller;

import com.example.transport.dto.PayRequestDto;
import com.example.transport.dto.PayResponseDto;
import com.example.transport.service.PayService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/pay")
@RequiredArgsConstructor
public class PayController {

    private final PayService payService;

    @GetMapping
    public List<PayResponseDto> findAll() {
        return payService.findAll();
    }

    @PostMapping
    public void create(@RequestBody PayRequestDto payRequestDto) {
        payService.createPay(payRequestDto);
    }

    @GetMapping("/{id}")
    public PayResponseDto getPayById(@PathVariable Long id) {
        return payService.getPayById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody PayRequestDto payRequestDto) {
        payService.update(id, payRequestDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        payService.delete(id);
    }
}

