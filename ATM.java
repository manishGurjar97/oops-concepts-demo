import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
       ATMOperations obj= new ATMOperations();
       
    }
}

class ATMOperations {

    private final int pin = 134;
    private float balance = 0.0f;

    ATMOperations() {
        Scanner sc = new Scanner(System.in);
        boolean isPinCorrect = false;

        while (!isPinCorrect) {
            System.out.print("Enter your PIN: ");
            int enteredPin = sc.nextInt();

            if (enteredPin == pin) {
                isPinCorrect = true;
                menu(sc);
            } else {
                System.out.println("Incorrect PIN. Please try again.");
            }
        }
        sc.close();
    }

    void menu(Scanner sc) {
        while (true) {
            System.out.println("\n==== ATM Menu ====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit(sc);
                    break;
                case 3:
                    withdraw(sc);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    void checkBalance() {
        System.out.println("Your current balance is: $" + balance);
    }

    void deposit(Scanner sc) {
        System.out.print("Enter amount to deposit: ");
        float amount = sc.nextFloat();
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    void withdraw(Scanner sc) {
        System.out.print("Enter amount to withdraw: ");
        float amount = sc.nextFloat();
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew $" + amount);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
        }
    }
}
