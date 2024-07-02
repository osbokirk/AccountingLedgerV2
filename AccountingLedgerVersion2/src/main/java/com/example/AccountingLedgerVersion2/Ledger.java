package com.example.AccountingLedgerVersion2;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Ledger {

    private static final Scanner scanner = new Scanner(System.in);
    static String fileName = "src/main/resources/transactions.csv";

    ArrayList<Transaction> list = reader();

    public static void deposits() throws IOException {
        System.out.println("Please enter your deposit information in the following format:");
        System.out.println("Description, vendor name, amount");
        String deposit = scanner.nextLine();

        // Split the input into its components
        String[] parts = deposit.split(",");


        if (parts.length < 3) {
            System.out.println("Invalid input format. Please enter at least description, vendor name, and amount.");
            return;
        }

        String description = parts[0].trim();
        String vendor = parts[1].trim();
        double amount;

        try {
            amount = Double.parseDouble(parts[2].trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount format. Please enter a valid number for amount.");
            return;
        }

        LocalDateTime now = LocalDateTime.now();

        String dateTime = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd|HH:mm:ss"));

        String entry = dateTime + "|" + description + "|" + vendor + "|" + amount;


        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            writer.write(entry);
            writer.newLine();
            writer.close();

            System.out.println("Deposit information has been successfully written to " + fileName);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void payments() throws IOException {
        System.out.println("Please enter your payment information in the following format:");
        System.out.println("Description, vendor name, amount");
        String payments = scanner.nextLine();

        String[] parts = payments.split(",");

        if (parts.length < 3) {
            System.out.println("Invalid input format. Please enter at least description, vendor name, and amount.");
            return;
        }

        String description = parts[0].trim();
        String vendor = parts[1].trim();
        double amount;

        try {
            amount = Double.parseDouble(parts[2].trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount format. Please enter a valid number for amount.");
            return;
        }


        amount *= -1;

        // Get the current date and time
        LocalDateTime now = LocalDateTime.now();

        // Format the date and time
        String dateTime = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd|HH:mm:ss"));

        String entry = dateTime + "|" + description + "|" + vendor + "|" + amount;

        try {
            // Create a BufferedWriter object to write to the CSV file
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            writer.write(entry);
            writer.newLine();
            writer.close();

            System.out.println("Deposit information has been successfully written to " + fileName);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //...............................................................................................................
    //ledger starts here
    public static ArrayList<Transaction> reader() {
        ArrayList<Transaction> transactions = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            reader.readLine();


            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\\|");
                LocalDateTime dateTime = LocalDateTime.parse(data[0] + "|" + data[1], DateTimeFormatter.ofPattern("yyyy-MM-dd|HH:mm:ss"));
                Double amount = Double.parseDouble(data[4]);
                Transaction transaction = new Transaction(dateTime, data[2], data[3], amount);
                transactions.add(transaction);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);

        }
        return transactions;
    }


    public static void allEntries() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            ArrayList<Transaction> transactions = reader();

            for (int i = transactions.size() - 1; i >= 0; i--) { //initializes variable i, that runs through elements
                Transaction transaction = transactions.get(i); //This means the loop will run until i reaches 0. i-- ititrates in reverse.
                System.out.println(transaction);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void depositOnly() throws FileNotFoundException {
            try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                ArrayList<Transaction> transactions = reader();

                for (int i = transactions.size() - 1; i >= 0; i--) {
                    Transaction transaction = transactions.get(i);
                    if (transaction.getAmount() > 0) {
                        System.out.println(transaction);
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    public static void paymentsOnly() throws FileNotFoundException{
            try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                ArrayList<Transaction> transactions = reader();

                for (int i = transactions.size() - 1; i >= 0; i--) {
                    Transaction transaction = transactions.get(i);
                    if (transaction.getAmount() < 0) { //since its a negative number, if less than 0 print
                        System.out.println(transaction);
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }




