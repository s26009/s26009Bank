package com.s26009.s26009bank.model;

public enum CarType {
    STANDARD(1),
    PREMIUM(1.5);
    private final double multiplier;

    CarType(double multiplier) {
        this.multiplier = multiplier;
    }
    public double getMultiplier() {
        return multiplier;
    }
}
