import java.util.*;
class Account {
    private String accountNumber;
    private String accountHolder;
    private double balance;
    private String pin;

    public Account(String accountNumber, String accountHolder, double balance, String pin) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
        this.pin = pin;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public boolean validatePin(String inputPin) {
        return this.pin.equals(inputPin);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: " + balance);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds.");
        }
    }

    public void displayBalance() {
        System.out.println("Current balance: " + balance);
    }
}

class ATM {
    private Map<String, Account> accounts;

    public ATM() {
        accounts = new HashMap<>();
        initializeAccounts();
    }

    private void initializeAccounts() {
        accounts.put("123456", new Account("123456", "John Doe", 1000.0, "1234"));
        accounts.put("654321", new Account("654321", "Jane Smith", 2000.0, "4321"));
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your account number: ");
        String accountNumber = scanner.nextLine();

        if (accounts.containsKey(accountNumber)) {
            Account account = accounts.get(accountNumber);
            System.out.print("Enter your PIN: ");
            String pin = scanner.nextLine();

            if (account.validatePin(pin)) {
                System.out.println("Welcome, " + account.getAccountHolder() + "!");
                performOperations(account, scanner);
            } else {
                System.out.println("Invalid PIN.");
            }
        } else {
            System.out.println("Account not found.");
        }
    }

    private void performOperations(Account account, Scanner scanner) {
        int choice;
        do {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    account.displayBalance();
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 4);
    }
}

public class ATMMachine {
    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.start();
    }
}


