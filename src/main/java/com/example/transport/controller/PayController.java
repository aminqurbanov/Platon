package com.example.transport.controller;

import com.example.transport.dto.PayRequestDto;
import com.example.transport.dto.PayResponseDto;
import com.example.transport.service.PayServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/v1/api/pay")
@RequiredArgsConstructor
public class PayController {
    private final PayServiceImpl payServiceImpl;
    @GetMapping
    public List<PayResponseDto> findAll() {
        return payServiceImpl.findAll();
    }
    @PostMapping()
    public void create(@RequestBody PayResponseDto payResponseDto){
        payServiceImpl.createPay(new PayRequestDto());
    }

    @GetMapping("/{id}")
    public PayResponseDto getCarById(@PathVariable Long id){
        return payServiceImpl.getPayById(id);

    }
    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody PayRequestDto  payRequestDto){
        PayServiceImpl.update(id,payRequestDto);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        payServiceImpl.delete(id);
    }
}
