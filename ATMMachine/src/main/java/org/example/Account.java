
package org.example;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Account {
    private int customerNumber;
    private int pinNumber;
    double savingAmount = 0;
    double personalAccountAmount = 0;
    Scanner scanner = new Scanner(System.in);

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public int getPinNumber() {
        return pinNumber;
    }

    public void setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
    }

    public double SavingCheckBalance() {
        return savingAmount;
    }

    public void SavingWithdrawal() {
        boolean ok = false;
        while (!ok) {
            System.out.println("Please enter the amount you want to withdraw: ");
            double amount = Double.parseDouble(scanner.next());
            if (amount > savingAmount) {
                System.out.println("Balance can't be negative!");
                System.out.println("Please enter a sum less than or equal with your balance.");
            } else {
                if (amount % 10 != 0) {
                    System.out.println("!Amount must be multiple of 10!");
                } else {
                    savingAmount = savingAmount - amount;
                    System.out.println("Please collect your money and remove the card.");
                    System.out.println("New balance is " + NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(SavingCheckBalance()));
                    ok = true;
                }
            }
        }

    }

    public void SavingDeposit() {
        System.out.println("Please enter the amount you want to deposit: ");
        double amount = Double.parseDouble(scanner.next());
        if (amount % 10 != 0) {
            System.out.println("!Amount must be multiple of 10!");
        } else {
            savingAmount = savingAmount + amount;
            System.out.println("The operation was performed successfully!.");
            System.out.println("New balance is " + NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(SavingCheckBalance()));
        }
    }

    public double PersonalAccountCheckBalance() {
        return personalAccountAmount;
    }

    public void PersonalAccountWithdrawal() {
        boolean ok = false;
        while (!ok) {
            System.out.println("Please enter the amount you want to withdraw: ");
            double amount = Double.parseDouble(scanner.next());
            if (amount > personalAccountAmount) {
                System.out.println("Balance can't be negative!");
            } else {
                if (amount % 10 != 0) {
                    System.out.println("!Amount must be multiple of 10!");
                } else {
                    personalAccountAmount = personalAccountAmount - amount;
                    System.out.println("Please collect your money and remove the card.");
                    System.out.println("New balance is " + NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(PersonalAccountCheckBalance()));
                    ok=true;
                }
            }
        }
    }

    public void PersonalAccountDeposit() {
        System.out.println("Please enter the amount you want to deposit: ");
        double amount = Double.parseDouble(scanner.next());
        if (amount % 10 != 0) {
            System.out.println("!Amount must be multiple of 10!");
        } else {
            personalAccountAmount = savingAmount + amount;
            System.out.println("The operation was performed successfully!.");
            System.out.println("New balance is " + NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(PersonalAccountCheckBalance()));
        }
    }
}
