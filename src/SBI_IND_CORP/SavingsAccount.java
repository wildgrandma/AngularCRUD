package SBI_IND_CORP;

public class SavingsAccount extends BankAccount {
    public SavingsAccount(String name, double initialBalance, Integer userId, String idProof) {
        super(name, initialBalance, userId, idProof);
    }

    // Implement abstract processPayment() method
    @Override
    public void processPayment() {
        System.out.println("Processing payment from Savings Account...");
    }
}
