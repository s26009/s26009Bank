package com.s26009.s26009bank.model;

public class User {
    private final String accId;
    public User(String accId) {
        this.accId = accId;
    }

    @Override
    public String toString() {
        return "userId: " + accId;
    }
}
