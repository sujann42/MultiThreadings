package com.threads.deadlock;

public class Account {
    private int balance = 10000;

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount){
        balance += amount;
    }
    public void withrdaw(int amount){
        balance -= amount;
    }

    public static void transfer(Account acc1, Account acc2, int amount){
        acc1.withrdaw(amount);
        acc2.deposit(amount);
    }
}
