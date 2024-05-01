package com.pluralsight;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Transaction {
    private LocalDateTime dateTime;
    private String description;
    private String vendor;
    private double amount;

    public Transaction(LocalDateTime dateTime, String description, String vendor, double amount) {
        this.dateTime = dateTime;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return dateTime.toLocalDate() + "|" + dateTime.format(DateTimeFormatter.ofPattern("HH:mm:ss")) + "|" + description + "|" + vendor + "|" + amount;
    }
}