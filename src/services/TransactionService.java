package services;

import Utils.FileUtils;
import models.Account;
import models.Transaction;
import java.util.ArrayList;

public class TransactionService {
    private ArrayList<Transaction> transactions;

    public TransactionService() {
        transactions = FileUtils.loadTransactions();
    }

    public void deposit(Account account, double amount) {
        account.deposit(amount);
        Transaction tx = new Transaction(account.getAccountNumber(), "Deposit", amount);
        transactions.add(tx);
        saveAll(account);
        System.out.println("✅ Deposit successful!");
    }

    public void withdraw(Account account, double amount) {
        if (account.withdraw(amount)) {
            Transaction tx = new Transaction(account.getAccountNumber(), "Withdraw", amount);
            transactions.add(tx);
            saveAll(account);
            System.out.println("✅ Withdrawal successful!");
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    public void showTransactions() {
        transactions.forEach(System.out::println);
    }

    private void saveAll(Account account) {
        FileUtils.saveTransactions(transactions);
    }
}
