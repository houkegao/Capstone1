package com.pluralsight;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
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
        boolean inReportsMenu = true;
        while (inReportsMenu) {
            System.out.println("=== Reports Menu ===");
            System.out.println("1) Month To Date");
            System.out.println("2) Previous Month");
            System.out.println("3) Year To Date");
            System.out.println("4) Previous Year");
            System.out.println("5) Search by Vendor");
            System.out.println("0) Back");
            System.out.print("Choose an option: ");
            String option = scanner.nextLine().trim();

            switch (option) {
                case "1":
                    generateReport("Month To Date");
                    break;
                case "2":
                    generateReport("Previous Month");
                    break;
                case "3":
                    generateReport("Year To Date");
                    break;
                case "4":
                    generateReport("Previous Year");
                    break;
                case "5":
                    searchByVendor(scanner);
                    break;
                case "0":
                    inReportsMenu = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void generateReport(String reportType) {
        System.out.println("=== " + reportType + " ===");
        LocalDateTime now = LocalDateTime.now();
        int year = now.getYear();
        int month = now.getMonthValue();

        try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                LocalDateTime transactionDate = LocalDateTime.parse(parts[0] + "T" + parts[1]);
                if (reportType.equals("Month To Date") && transactionDate.getMonthValue() == month && transactionDate.getYear() == year) {
                    System.out.println(line);
                } else if (reportType.equals("Year To Date") && transactionDate.getYear() == year) {
                    System.out.println(line);
                } else if (reportType.equals("Previous Month")) {
                    LocalDateTime previousMonth = now.minusMonths(1);
                    if (transactionDate.getMonthValue() == previousMonth.getMonthValue() && transactionDate.getYear() == previousMonth.getYear()) {
                        System.out.println(line);
                    }
                } else if (reportType.equals("Previous Year")) {
                    if (transactionDate.getYear() == year - 1) {
                        System.out.println(line);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading ledger: " + e.getMessage());
        }
    }

    private static void searchByVendor(Scanner scanner) {
        System.out.print("Enter vendor name: ");
        String vendorName = scanner.nextLine().trim();
        System.out.println("=== Transactions for Vendor: " + vendorName + " ===");
        try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts[3].equalsIgnoreCase(vendorName)) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading ledger: " + e.getMessage());
        }
    }
}