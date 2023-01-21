package com.s26009.s26009bank.model;

public enum TransactionType {
    ACCEPTED(1),
    DECLINED(1.5);
    private final double multiplier;

    TransactionType(double multiplier) {
        this.multiplier = multiplier;
    }
    public double getMultiplier() {
        return multiplier;
    }
}
