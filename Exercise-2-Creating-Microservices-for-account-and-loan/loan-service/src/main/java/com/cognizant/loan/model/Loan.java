package com.cognizant.loan.model;

public class Loan {

    private int loanId;
    private String loanType;
    private double loanAmount;
    private double interestRate;
    private String customerName;

    public Loan() {
    }

    public Loan(int loanId, String loanType, double loanAmount,
                double interestRate, String customerName) {
        this.loanId = loanId;
        this.loanType = loanType;
        this.loanAmount = loanAmount;
        this.interestRate = interestRate;
        this.customerName = customerName;
    }

    public int getLoanId() { return loanId; }
    public void setLoanId(int loanId) { this.loanId = loanId; }

    public String getLoanType() { return loanType; }
    public void setLoanType(String loanType) { this.loanType = loanType; }

    public double getLoanAmount() { return loanAmount; }
    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public double getInterestRate() { return interestRate; }
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public String toString() {
        return "Loan[loanId=" + loanId
                + ", loanType=" + loanType
                + ", loanAmount=" + loanAmount
                + ", interestRate=" + interestRate
                + ", customerName=" + customerName + "]";
    }
}
