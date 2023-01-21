package com.s26009.s26009bank.storage;

import com.s26009.s26009bank.model.BankAccount;
import com.s26009.s26009bank.model.Transaction;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class BankAccountStorage {
    private final List<BankAccount> bankAccountList = new ArrayList<>();

    public BankAccountStorage() {
        bankAccountList.add(new BankAccount("user1", 10000));
        bankAccountList.add(new BankAccount("user2", 20000));
        bankAccountList.add(new BankAccount("user3", 30000));
    }

    public void addNewBankAccount(BankAccount bankAccount) {
        bankAccountList.add(bankAccount);
    }

    public Optional<BankAccount> findBankAccountByAccId(String accId) {
        return getBankAccountList().stream()
                .filter(storage -> storage.getAccId().equals(accId))
                .findFirst();
    }

    public List<BankAccount> getBankAccountList() {
        return bankAccountList;
    }
}
