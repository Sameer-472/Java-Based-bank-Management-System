package services;

import models.Account;
import Utils.FileUtils;

import java.util.HashMap;

public class AccountService {
    private HashMap<String, Account> accounts;

    public AccountService() {
        accounts = FileUtils.loadAccounts();
    }

    public void createAccount(String accountNumber, String customerName, double initialDeposit) {
        if (!accounts.containsKey(accountNumber)) {
            Account account = new Account(accountNumber, customerName, initialDeposit);
            accounts.put(accountNumber, account);
            FileUtils.saveAccounts(accounts);
            System.out.println("✅ Account created successfully!");
        } else {
            System.out.println("Account already exists!");
        }
    }

    public Account getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }

    public void updateAccounts() {
        FileUtils.saveAccounts(accounts);
    }

    public void displayAccounts() {
        accounts.values().forEach(System.out::println);
    }
}
