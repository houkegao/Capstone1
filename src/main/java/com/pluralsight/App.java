package com.pluralsight;
import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

public class App {
    private static final String CSV_FILE = "transactions.csv";
    private static final String CSV_HEADER = "date|time|description|vendor|amount";

    private static void addDeposit(Scanner scanner) {
        System.out.println("=== Add Deposit ===");
        System.out.print("Enter description: ");
        String description = scanner.nextLine().trim();
        System.out.print("Enter vendor: ");
        String vendor = scanner.nextLine().trim();
        double amount = 0;
        boolean validAmount = false;
        while (!validAmount) {
            try {
                System.out.print("Enter amount: ");
                amount = Double.parseDouble(scanner.nextLine());
                if (amount < 0) {
                    throw new IllegalArgumentException("Amount must be a positive number.");
                }
                validAmount = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid amount. Pleadse enter a valid number.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        LocalDateTime dateTime = LocalDateTime.now();
        Transaction deposit = new Transaction(dateTime, description, vendor, amount);
        // TODO: save transaction
        System.out.println("Deposit added successfully.");
    }

    private static void makePayment(Scanner scanner) {
        System.out.println("=== Make Payment (Debit) ===");
        System.out.print("Enter description: ");
        String description = scanner.nextLine().trim();
        System.out.print("Enter vendor: ");
        String vendor = scanner.nextLine().trim();
        LocalDateTime dateTime = LocalDateTime.now();
        double amount = 0;
        boolean validAmount = false;
        while (!validAmount) {
            try {
                System.out.print("Enter amount: ");
                amount = Double.parseDouble(scanner.nextLine());
                if (amount >= 0) {
                    throw new IllegalArgumentException("Amount must be a negative number.");
                }
                validAmount = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid amount. Please enter a valid number.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        Transaction payment = new Transaction(dateTime, description, vendor, amount);
        // TODO: save transaction
        System.out.println("Payment made successfully.");
    }

    private static void displayLedger(Scanner scanner) {
        // Implement ledger display logic here
    }

    public static void main(String[] args) {
        System.out.println("hello");
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        
        while (running) {
            System.out.println("=== Home Screen ===");
            System.out.println("D) Add Deposit");
            System.out.println("P) Make Payment (Debit)");
            System.out.println("L) Ledger");
            System.out.println("X) Exit");
            System.out.print("Choose an option: ");
            String option = scanner.nextLine().trim().toUpperCase();
            switch (option) {
                case "D":
                    addDeposit(scanner);
                    break;
                case "P":
                    makePayment(scanner);
                    break;
                case "L":
                    displayLedger(scanner);
                    break;
                case "X":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
