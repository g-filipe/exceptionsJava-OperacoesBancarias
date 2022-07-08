package model.entities;

import model.exceptions.BusinessException;

public class BankAccount {
    private Integer number;
    private String holder;
    private double balance;
    private Double withdrawLimit;

    public BankAccount() {
    }

    public BankAccount(Integer number, String holder, double initialDeposit, Double withdrawLimit) {
        this.number = number;
        this.holder = holder;
        deposit(initialDeposit);
        this.withdrawLimit = withdrawLimit;
    }

    public Integer getNumber() {
        return number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void setWithdrawLimit(Double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }

    public Double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdraw(double amount) {
        validateWithdraw(amount);
        this.balance -= amount;
    }

    public void validateWithdraw(double amount) {
        if (amount > getWithdrawLimit()) {
            throw new BusinessException("Withdraw error: The amount exceeds withdraw limit");
        }
        if (amount > getBalance()) {
            throw new BusinessException("Withdraw error: Not enough balance");
        }
    }
}
