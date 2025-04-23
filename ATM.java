package atm;

import java.io.*;

public class ATM {
    private double balance;
    private final String dataFile;

    public ATM(String dataFile) {
        this.dataFile = dataFile;
        load();
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: $" + amount);
        } else {
            System.out.println("Insufficient funds or invalid amount.");
        }
    }

    public final void load() {
        File file = new File(dataFile);
        if (!file.exists()) {
            balance = 0;
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            balance = Double.parseDouble(reader.readLine());
        } catch (IOException | NumberFormatException e) {
            balance = 0;
        }
    }

    public void save() {
        File dir = new File(dataFile).getParentFile();
        if (!dir.exists()) dir.mkdirs();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(dataFile))) {
            writer.write(String.valueOf(balance));
        } catch (IOException e) {
            System.out.println("Error saving data.");
        }
    }
}