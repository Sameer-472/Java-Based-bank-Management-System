package Utils;

import models.Account;
import models.Transaction;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class FileUtils {
    private static final String ACCOUNT_FILE = "accounts.dat";
    private static final String TRANSACTION_FILE = "transactions.dat";

    @SuppressWarnings("unchecked")
    public static HashMap<String, Account> loadAccounts() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ACCOUNT_FILE))) {
            return (HashMap<String, Account>) ois.readObject();
        } catch (Exception e) {
            return new HashMap<>();
        }
    }

    public static void saveAccounts(HashMap<String, Account> accounts) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ACCOUNT_FILE))) {
            oos.writeObject(accounts);
        } catch (Exception e) {
            System.out.println("⚠️ Error saving accounts!");
        }
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Transaction> loadTransactions() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(TRANSACTION_FILE))) {
            return (ArrayList<Transaction>) ois.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public static void saveTransactions(ArrayList<Transaction> transactions) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(TRANSACTION_FILE))) {
            oos.writeObject(transactions);
        } catch (Exception e) {
            System.out.println("⚠️ Error saving transactions!");
        }
    }
}
