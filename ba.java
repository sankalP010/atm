import java.util.Scanner;

class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;

    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
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

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit of $" + amount + " successful. Current balance: $" + balance);
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawal of $" + amount + " successful. Current balance: $" + balance);
        } else {
            System.out.println("Insufficient funds. Current balance: $" + balance);
        }
    }
}

public class BankingApplication {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("123456789", "John Doe", 1000.0);

        Scanner scanner = new Scanner(System.in);
        int choice;
        double amount;

        do {
            System.out.println("Banking Application");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Account Holder: " + account.getAccountHolder());
                    System.out.println("Account Number: " + account.getAccountNumber());
                    System.out.println("Current Balance: $" + account.getBalance());
                    break;
                case 2:
                    System.out.print("Enter the amount to deposit: $");
                    amount = scanner.nextDouble();
                    account.deposit(amount);
                    break;
                case 3:
                    System.out.print("Enter the amount to withdraw: $");
                    amount = scanner.nextDouble();
                    account.withdraw(amount);
                    break;
                case 0:
                    System.out.println("Thank you for using the banking application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        } while (choice != 0);

        scanner.close();
    }
}
