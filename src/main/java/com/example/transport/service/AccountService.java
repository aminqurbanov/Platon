package com.example.transport.service;

import com.example.transport.entity.Account;
import com.example.transport.repository.AccountRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountService {
    private final EntityManagerFactory entityManagerFactory;
    public void transferProxy(Long fromId, Long toId, Double amount) throws Exception{
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

    try{
        Account from = em.find(Account.class,fromId);
        Account to = em.find(Account.class,toId);
        transfer(from,to,amount);

    }catch (RuntimeException e){
        em.getTransaction().rollback();
    }finally {
        em.getTransaction().commit();
        em.close();
        }
    }

    public void  transfer(Account from, Account to, Double amount) throws Exception{
        if (from.getBalance() <= amount){
            throw new RuntimeException("Balance not enough");
        }
        from.setBalance(from.getBalance() - amount);
        log.info("i am waiting for 5 seconds,because internet connection not suitable");
        to.setBalance(to.getBalance() + amount);
        Thread.sleep(10000);

    }
}
