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

    public boolean registerNewBankAccount(String accId, int amount) {
        Optional<BankAccount> bankAccountOptional = findBankAccountByAccId(accId);
        if (bankAccountOptional.isEmpty()) {
            BankAccount newBankAccount = new BankAccount(accId, amount);
            bankAccountStorage.addNewBankAccount(newBankAccount);
            System.out.println("User '" + accId + " is added to storage.");
            return true;
        } else {
            System.out.println("User ID is already used.");
            return false;
        }
    }

    public Optional<BankAccount> findBankAccountByAccId(String accId) {
        return bankAccountStorage.findBankAccountByAccId(accId);
    }

    public Transaction makeNewTransaction(String accId, int amount) {
        Optional<BankAccount> bankAccountOptional = findBankAccountByAccId(accId);
        if (bankAccountOptional.isPresent()) {
            Transaction newTransaction = new Transaction(bankAccountOptional.get(), amount);
            transactionStorage.addNewTransaction(newTransaction);
            System.out.println("Transaction for '" + accId + "' is added to storage.");
            return newTransaction;
        } else {
            System.out.println("User ID doesn't exist.");
            return null;
        }
    }

    public BankAccount getBankAccountInfo(String accId) {
        return bankAccountStorage.findBankAccountByAccId(accId).orElse(null);
    }

    public List<BankAccount> getAllBankAccounts() {
        return bankAccountStorage.getBankAccountList();
    }

    public List<Transaction> getAllTransactions() {
        return transactionStorage.getTransactionList();
    }
}
