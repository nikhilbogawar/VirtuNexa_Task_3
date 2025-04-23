package atm;

import java.util.Scanner;

public class ATMApp {
    public static void main(String[] args) {
        ATM atm = new ATM("data/account.txt");
        boolean running = true;

        try (Scanner scanner = new Scanner(System.in)) {
            while (running) {
            System.out.println("\nATM Simulator");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> System.out.printf("Current Balance: $%.2f%n", atm.getBalance());
                case "2" -> {
                    System.out.print("Enter amount to deposit: ");
                    try {
                        double amount = Double.parseDouble(scanner.nextLine());
                        atm.deposit(amount);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input.");
                    }
                }
                case "3" -> {
                    System.out.print("Enter amount to withdraw: ");
                    try {
                        double amount = Double.parseDouble(scanner.nextLine());
                        atm.withdraw(amount);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input.");
                    }
                }
                case "4" -> {
                    atm.save();
                    running = false;
                }
                default -> System.out.println("Invalid option.");
            }
        }

            System.out.println("Thank you for using the ATM.");
        }
    }
}