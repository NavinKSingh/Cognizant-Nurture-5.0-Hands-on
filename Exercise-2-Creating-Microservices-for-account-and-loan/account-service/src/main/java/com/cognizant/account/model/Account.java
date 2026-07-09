package com.cognizant.account.model;

public class Account {

    private int accountNumber;
    private String accountType;
    private double balance;
    private String customerName;

    public Account() {
    }

    public Account(int accountNumber, String accountType,
                   double balance, String customerName) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
        this.customerName = customerName;
    }

    public int getAccountNumber() { return accountNumber; }
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() { return accountType; }
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public String toString() {
        return "Account[accountNumber=" + accountNumber
                + ", accountType=" + accountType
                + ", balance=" + balance
                + ", customerName=" + customerName + "]";
    }
}
