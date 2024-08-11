package org.example;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

public class OptionMenu extends Account {

    HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();
    Scanner scanner = new Scanner(System.in);

    public void login() throws IOException {
        boolean ok = false;//datele nu au fost introduse
        do {
            try {
                data.put(31, 2002);
                System.out.println("--Welcome to the ATM!--");
                System.out.println("Enter your customer number:");
                setCustomerNumber(scanner.nextInt());

                System.out.println("Enter your PIN:");
                setPinNumber(scanner.nextInt());
                ok = true;
            } catch (Exception e) {
                System.out.println("Invalid input!!! Use numbers only!");
                ok = true;
            }
            int customerNumber = getCustomerNumber();
            int pinNumber = getPinNumber();
            if (data.containsKey(customerNumber) && data.get(customerNumber) == pinNumber) {
                getAccountType();
            } else System.out.println("Customer number or PIN is incorrect!!!");
        } while (!ok);
    }

    public void getAccountType() {
        System.out.println("Select the account you want to access");
        System.out.println("Press 1 for Personal Account");
        System.out.println("Press 2 for Saving Account");
        System.out.println("Press 0 for EXIT");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                getPersonalAccount();
                break;
            case 2:
                getSavingAccount();
                break;
            case 0: {
                System.out.println("Thank you for using this ATM! Have a good day!");
                System.exit(0);
            }
            default:
                System.out.println("Invalid input!!!");
        }
    }

    public void getSavingAccount() {
        System.out.println("¬Saving Account¬");
        System.out.println("Press 1 - Check balance");
        System.out.println("Press 2 - Cash withdrawal");
        System.out.println("Press 3 - Cash deposit");
        System.out.println("Press 0 - EXIT");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Your account balance is: " + NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(SavingCheckBalance()));
                getAccountType();
                break;
            case 2:
                SavingWithdrawal();
                getAccountType();
                break;
            case 3:
                SavingDeposit();
                getAccountType();
                break;
            case 0: {
                System.out.println("Thank you for using this ATM! Have a good day!");
                System.exit(0);
            }
            default:
                System.out.println("Invalid input!!!");
        }
    }

    public void getPersonalAccount() {
        System.out.println("¬Personal Account¬");
        System.out.println("Press 1 - Check balance");
        System.out.println("Press 2 - Cash withdrawal");
        System.out.println("Press 3 - Cash deposit");
        System.out.println("Press 0 - EXIT");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Your account balance is: " + NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(PersonalAccountCheckBalance()));
                getAccountType();
                break;
            case 2:
                PersonalAccountWithdrawal();
                getAccountType();
                break;
            case 3:
                PersonalAccountDeposit();
                getAccountType();
                break;
            case 0: {
                System.out.println("Thank you for using this ATM! Have a good day!");
                System.exit(0);
            }
            default:
                System.out.println("Invalid input!!!");
        }
    }

}
