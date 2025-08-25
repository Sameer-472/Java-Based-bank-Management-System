import models.Account;
import services.AccountService;
import services.TransactionService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AccountService accountService = new AccountService();
        TransactionService transactionService = new TransactionService();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Bank Management System =====");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. View Accounts");
            System.out.println("5. View Transactions");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Account Number: ");
                    String accNum = sc.next();
                    System.out.print("Enter Customer Name: ");
                    String name = sc.next();
                    System.out.print("Enter Initial Deposit: ");
                    double deposit = sc.nextDouble();
                    accountService.createAccount(accNum, name, deposit);
                    break;

                case 2:
                    System.out.print("Enter Account Number: ");
                    accNum = sc.next();
                    Account acc = accountService.getAccount(accNum);
                    if (acc != null) {
                        System.out.print("Enter Deposit Amount: ");
                        double amt = sc.nextDouble();
                        transactionService.deposit(acc, amt);
                        accountService.updateAccounts();
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 3:
                    System.out.print("Enter Account Number: ");
                    accNum = sc.next();
                    acc = accountService.getAccount(accNum);
                    if (acc != null) {
                        System.out.print("Enter Withdraw Amount: ");
                        double amt = sc.nextDouble();
                        transactionService.withdraw(acc, amt);
                        accountService.updateAccounts();
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 4:
                    accountService.displayAccounts();
                    break;

                case 5:
                    transactionService.showTransactions();
                    break;

                case 0:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
