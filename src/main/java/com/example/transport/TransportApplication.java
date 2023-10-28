package com.example.transport;

import com.example.transport.entity.Account;
import com.example.transport.repository.AccountRepository;
import com.example.transport.service.AccountService;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class TransportApplication implements CommandLineRunner {

    private final AccountRepository accountRepository;
    private final AccountService accountService;
    private final EntityManager entityManager;

    public static void main(String[] args) {
        SpringApplication.run(TransportApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

       Account from = accountRepository.findById(5L).get();
       Account to = accountRepository.findById(6L).get();
//       accountService.transfer(from,to,30.0);
        accountService.transferProxy(5L,6L,30.0);
    }
}
