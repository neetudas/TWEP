package com.example1;

/**
 * Created by user on 01-04-2016.
 */
public class Account {
    private Double balance;
    String name;
    public Account(String name, Double balance) {
        this.name = name;
        this.balance = balance;
    }

    public void withdraw(double withdrawAmount) throws Exception{
        if (withdrawAmount < 0) {
            throw new IllegalArgumentException();
        }

        this.balance -= withdrawAmount;
    }

    public double getBalance() {
        return this.balance;
    }
}
