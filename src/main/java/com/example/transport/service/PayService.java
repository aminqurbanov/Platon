package com.example.transport.service;

import com.example.transport.dto.PayRequestDto;
import com.example.transport.dto.PayResponseDto;
import com.example.transport.entity.Pay;
import com.example.transport.repository.PayRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PayService implements PayServiceImpl {
    private final ModelMapper modelMapper;
    private final PayRepository payRepository;
    @Override
    public List<PayResponseDto> findAll() {
        return payRepository
                .findAll()
                .stream()
                .map(pay -> modelMapper.map(pay, PayResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public PayResponseDto getPayById(Long id) {
        Pay pay = payRepository.findById(id).get();
        return modelMapper.map(pay, PayResponseDto.class);
    }

    @Override
    public void createPay(PayRequestDto payRequestDto) {
        Pay pay = modelMapper.map(payRequestDto,Pay.class);
        payRepository.save(pay);

    }

    @Override
    public void delete(Long id) {
        payRepository.deleteById(id);

    }
}
