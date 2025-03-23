package SBI_IND_CORP;

import java.util.concurrent.atomic.AtomicLong;

public abstract class BankAccount implements Transactions {
    private String name;
    private final long accountNumber;
    private double balance;
    private Integer userId;
    private String idProof;

    private static final AtomicLong ACCOUNT_NUMBER_GENERATOR = new AtomicLong(1000000000L);

    // Constructor
    public BankAccount(String name, double initialBalance, Integer userId, String idProof) {
        this.name = name;
        this.accountNumber = ACCOUNT_NUMBER_GENERATOR.getAndIncrement();
        this.balance = initialBalance;
        this.userId = userId;
        this.idProof = generateHash(idProof);
    }

    // Deposit method (Public API)
    public void deposit(double amount) {
        if (amount > 0) {
            updateBalance(amount);
            System.out.println("Deposited $" + amount + " | New Balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    // Withdraw method (Public API)
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            updateBalance(-amount);
            System.out.println("Withdrawn $" + amount + " | New Balance: $" + balance);
        } else {
            System.out.println("Insufficient funds or invalid amount!");
        }
    }

    // ✅ Private method to update balance (Encapsulation & Abstraction)
    private void updateBalance(double amount) {
        balance += amount; // Hiding internal balance update logic
    }

    // Validate User ID (Implemented from Transactions)
    @Override
    public boolean verifyUserID() {
        return userId != null && userId > 0;
    }

    // Abstract method for account-specific processing
    public abstract void processPayment();

    // Getter for balance (Read-only)
    public double getBalance() {
        return balance;
    }

    public void displayAccountInfo() {
        System.out.println("Account Holder: " + name);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: $" + balance);
    }

    // Hashing Function for ID Proof (Encapsulation)
    private String generateHash(String id) {
        return String.valueOf(id.hashCode());
    }
}
