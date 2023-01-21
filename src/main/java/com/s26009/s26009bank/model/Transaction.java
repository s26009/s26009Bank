package com.s26009.s26009bank.model;

public class Transaction {
    private final BankAccount bankAccount;
    private final int amount;
    private final TransactionType type;

    public Transaction(BankAccount bankAccount, int amount, TransactionType type) {
        this.bankAccount = bankAccount;
        this.amount = amount;
        this.type = type;
    }

    @Override
    public String toString() {
        return "from" + bankAccount + " " + amount + " result: " + type;
    }
}
