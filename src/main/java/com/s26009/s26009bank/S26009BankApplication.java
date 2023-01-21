package com.s26009.s26009bank;

import com.s26009.s26009bank.model.BankAccount;
import com.s26009.s26009bank.model.Transaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class S26009BankApplication {

    public S26009BankApplication(BankService bankService) {

        BankAccount newBankAccount = bankService.registerNewBankAccount("hleb", 500);
        System.out.println(newBankAccount);
        Transaction transaction = bankService.makeNewTransaction("hleb", -300);
        System.out.println(transaction);
        BankAccount bankAccountInfo = bankService.getBankAccountInfo("hleb");
        System.out.println(bankAccountInfo);
    }

    public static void main(String[] args) {
        SpringApplication.run(S26009BankApplication.class, args);
    }

}
