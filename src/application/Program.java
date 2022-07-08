package application;

import model.entities.BankAccount;
import model.exceptions.BusinessException;

import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter account data");
        System.out.print("Number: ");
        int accountNumber = sc.nextInt();
        System.out.print("Holder: ");
        sc.nextLine();
        String accountHolder = sc.nextLine();
        System.out.print("Initial deposit amount: ");
        double depositAmount = sc.nextDouble();
        System.out.print("Withdraw limit: ");
        double withdrawLimit = sc.nextDouble();

        BankAccount account = new BankAccount(accountNumber, accountHolder, depositAmount, withdrawLimit);

        System.out.print("Enter amount for withdraw: ");
        double withdrawAmount = sc.nextDouble();

        try {
            account.withdraw(withdrawAmount);
            System.out.printf("Succeed! New balance: $%.2f", account.getBalance());
        } catch (BusinessException e) {
            System.out.println(e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Unexpected Error.");
        }
        sc.close();
    }
}
