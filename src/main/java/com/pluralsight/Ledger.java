package com.pluralsight;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ledger {
    private static final String CSV_FILE = "transactions.csv";

    public static void displayLedger(String filter) {
        System.out.println("=== Ledger: " + filter + " ===");
        try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (filter.equals("Deposits") && Double.parseDouble(parts[4]) < 0) {
                    continue;
                } else if (filter.equals("Payments") && Double.parseDouble(parts[4]) >= 0) {
                    continue;
                }
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading ledger: " + e.getMessage());
        }
    }


    public static void reportsMenu(Scanner scanner) {
        // TODO
    }

    private static void generateReport(String reportType) {
        // TODO
    }

    private static void searchByVendor(Scanner scanner) {
        // TODO
    }
}