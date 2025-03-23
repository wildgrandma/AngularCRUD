package SBI_IND_CORP;

public class CheckingAccount extends BankAccount {
    public CheckingAccount(String name, double initialBalance, Integer userId, String idProof) {
        super(name, initialBalance, userId, idProof);
    }

    // Implement abstract processPayment() method
    @Override
    public void processPayment() {
        System.out.println("Processing payment from Checking Account...");
    }
}
