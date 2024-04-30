package com.pluralsight;
import java.io.*;
import java.util.*;

public class App {
    private static final String CSV_FILE = "transactions.csv";
    private static final String CSV_HEADER = "date|time|description|vendor|amount";
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
            running = false;
        }
    }
}
