package com.s26009.s26009bank.model;

public class BankAccount {
    private final String accId;
    public BankAccount(String accId) {
        this.accId = accId;
    }

    @Override
    public String toString() {
        return "accId: " + accId;
    }
}
