package models;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Transaction implements Serializable {
    private String accountNumber;
    private String type; // Deposit / Withdraw
    private double amount;
    private LocalDateTime dateTime;

    public Transaction(String accountNumber, String type, double amount) {
        this.accountNumber = accountNumber;
        this.type = type;
        this.amount = amount;
        this.dateTime = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "accountNumber='" + accountNumber + '\'' +
                ", type='" + type + '\'' +
                ", amount=" + amount +
                ", dateTime=" + dateTime +
                '}';
    }
}
