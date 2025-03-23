package SBI_IND_CORP;

import java.util.concurrent.atomic.AtomicLong;

public class BankAccount { private String name;
    private final long accountNumber; // Made final to prevent modification
    private Integer userId;
    private String idProof;

    // Static counter for auto-generating account numbers
    private static final AtomicLong ACCOUNT_NUMBER_GENERATOR = new AtomicLong(1000000000L);

    // Constructor
    public BankAccount(String name, Integer userId, String idProof) {
        this.name = name;
        this.accountNumber = ACCOUNT_NUMBER_GENERATOR.getAndIncrement(); // Auto-generate account number
        this.userId = userId;
        this.idProof = generateHash(idProof); // Store hashed ID proof
    }

    // Getter and Setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getAccountNumber() {
        return accountNumber; // No setter for immutable property
    }

    public String getIdProof() {
        return idProof;
    }

    public void setIdProof(String idProof) {
        this.idProof = generateHash(idProof);
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    // ID Validation Logic
    public boolean validateID(String idHash) {
        return generateHash(idHash).equals(idProof);
    }

    // Hashing Function for ID Proof
    private String generateHash(String id) {
        return String.valueOf(id.hashCode());
    }

    // Display Account Details
    public void displayAccountDetails() {
        System.out.println("Account Holder: " + name);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("User ID: " + userId);
    }
}
