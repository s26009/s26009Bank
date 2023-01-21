package com.s26009.s26009bank;

import com.s26009.s26009bank.model.BankAccount;
import com.s26009.s26009bank.model.Transaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class S26009BankApplication {

    public S26009BankApplication(BankService bankService) {

        bankService.registerNewBankAccount("hleb", 500);
        Transaction transaction = bankService.makeNewTransaction("hleb", -300);
        System.out.println(transaction);
        BankAccount bankAccountInfo = bankService.getBankAccountInfo("hleb");
        System.out.println(bankAccountInfo);
        Transaction transaction2 = bankService.makeNewTransaction("hleb", -300);
        System.out.println(transaction2);
        BankAccount bankAccountInfo2 = bankService.getBankAccountInfo("hleb");
        System.out.println(bankAccountInfo2);
    }

    public static void main(String[] args) {
        SpringApplication.run(S26009BankApplication.class, args);
    }

}
