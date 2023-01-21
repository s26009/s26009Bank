package com.s26009.s26009bank;

import com.s26009.s26009bank.model.BankAccount;
import com.s26009.s26009bank.model.Transaction;
import com.s26009.s26009bank.storage.BankAccountStorage;
import com.s26009.s26009bank.storage.TransactionStorage;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BankService {
    private final BankAccountStorage bankAccountStorage;
    private final TransactionStorage transactionStorage;

    public BankService(BankAccountStorage bankAccountStorage, TransactionStorage transactionStorage) {
        this.bankAccountStorage = bankAccountStorage;
        this.transactionStorage = transactionStorage;
    }

    public BankAccount registerNewBankAccount(String accId, int amount) {
        return null;
    }

    public Transaction makeNewTransaction(String accId, int amount) {
        return null;
    }

    public BankAccount getBankAccountInfo(String accId) {
        return null;
    }

    public List<BankAccount> getAllBankAccounts() {
        return bankAccountStorage.getBankAccountList();
    }

    public List<Transaction> getAllTransactions() {
        return transactionStorage.getTransactionList();
    }
}
