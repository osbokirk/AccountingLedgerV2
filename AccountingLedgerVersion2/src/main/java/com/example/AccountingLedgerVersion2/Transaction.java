package com.example.AccountingLedgerVersion2;

import java.sql.Time;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Transaction {

    private LocalDateTime dateTime;
    private Date date;
    private Time time;
    private String description;
    private String vendor;
    private double amount;

    public Transaction(Date date,Time time, String description, String vendor, double amount) {
        this.date = date;
        this.time = time;
        this.dateTime = dateTime;
        this.description = description;
        this.vendor = vendor ;
        this.amount = amount;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String toString() {
        LocalDateTime dateTime = getDateTime();
        String formattedDateTime = dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd|HH:mm:ss"));
        String output = formattedDateTime + "|" +getDescription() + "|" + getVendor() + "|" + getAmount();
        return output;


    }



}

