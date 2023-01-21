package com.s26009.s26009bank.storage;

import com.s26009.s26009bank.model.BankAccount;
import com.s26009.s26009bank.model.Transaction;
import com.s26009.s26009bank.model.TransactionType;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TransactionStorage {
    private final List<Transaction> transactionList = new ArrayList<>();

    public TransactionStorage() {
        transactionList.add(new Transaction(new BankAccount("user1", 10000), 500));
        transactionList.add(new Transaction(new BankAccount("user2", 20000), 720));
    }
    public void addNewTransaction(Transaction transaction) {
        transactionList.add(transaction);
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

}
