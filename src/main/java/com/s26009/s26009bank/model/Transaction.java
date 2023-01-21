package com.s26009.s26009bank.model;

public class Transaction {
    private final BankAccount bankAccount;
    private final int amount;
    private final TransactionType type;

    public Transaction(BankAccount bankAccount, int amount) {
        this.bankAccount = bankAccount;
        this.amount = amount;
        if (bankAccount.getSaldo() + amount > 0) {
            bankAccount.setSaldo(bankAccount.getSaldo() + amount);
            this.type = TransactionType.ACCEPTED;
        } else {
            this.type = TransactionType.DECLINED;
        }
    }

    @Override
    public String toString() {
        return "from" + bankAccount + " " + amount + " result: " + type;
    }
}
