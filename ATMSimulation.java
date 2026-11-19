
import java.util.Scanner;

public class ATMSimulation {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int correctPIN = 1234;
        int pin;
        int attempts = 0;
        boolean login = false;

        double balance = 50000;

        String[] transactions = new String[100];
        int count = 0;

        // STEP 1: PIN authentication
        while (attempts < 3) {

            System.out.print("Enter your PIN: ");
            pin = input.nextInt();

            if (pin == correctPIN) {
                login = true;
                System.out.println("Login successful!");
                break;
            } else {
                attempts++;
                System.out.println("Wrong PIN!");

                System.out.println("Attempts left: " 
                                   + (3 - attempts));
            }
        }

        // STEP 2: Check login
        if (login) {

            int choice = 0;

            // STEP 3: ATM menu
            while (choice != 5) {

                System.out.println("\n===== ATM MENU =====");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit Money");
                System.out.println("3. Withdraw Money");
                System.out.println("4. Transaction History");
                System.out.println("5. Exit");

                System.out.print("Choose an option: ");
                choice = input.nextInt();

                // OPTION 1: Check balance
                if (choice == 1) {

                    System.out.println("Your balance is: "
                                       + balance + " RWF");
                }

                // OPTION 2: Deposit
                else if (choice == 2) {

                    System.out.print("Enter deposit amount: ");
                    double amount = input.nextDouble();

                    if (amount > 0 && count < 100) {

                        balance = balance + amount;

                        transactions[count] =
                            "Deposited: " + amount + " RWF";

                        count++;

                        System.out.println("Deposit successful!");
                    } else {
                        System.out.println("Invalid amount!");
                    }
                }

                // OPTION 3: Withdraw
                else if (choice == 3) {

                    System.out.print("Enter withdrawal amount: ");
                    double amount = input.nextDouble();

                    if (amount > 0 && amount <= balance
                        && count < 100) {

                        balance = balance - amount;

                        transactions[count] =
                            "Withdrawn: " + amount + " RWF";

                        count++;

                        System.out.println("Withdrawal successful!");
                    } else {
                        System.out.println(
                            "Insufficient balance or invalid amount!");
                    }
                }

                // OPTION 4: Transaction history
                else if (choice == 4) {

                    System.out.println("\nTransaction History:");

                    if (count == 0) {
                        System.out.println("No transactions yet.");
                    }

                    for (int i = 0; i < count; i++) {
                        System.out.println(transactions[i]);
                    }
                }

                // OPTION 5: Exit
                else if (choice == 5) {

                    System.out.println("Thank you for using our ATM!");
                }

                else {
                    System.out.println("Invalid choice. Try again!");
                }
            }

        } else {

            System.out.println("Your account is locked!");
        }

        input.close();
    }
}
