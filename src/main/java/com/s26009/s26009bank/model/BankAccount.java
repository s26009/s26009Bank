package com.s26009.s26009bank.model;

public class BankAccount {
    private final String accId;
    private int saldo;

    public BankAccount(String accId, int saldo) {
        this.accId = accId;
        this.saldo = saldo;
    }

    public String getAccId() {
        return accId;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "accId=" + accId + ", saldo=" + saldo;
    }
}
