import SBI_IND_CORP.BankAccount;
import SBI_IND_CORP.CheckingAccount;
import SBI_IND_CORP.SavingsAccount;

public class Main {
    public static void main(String[] args) {
        BankAccount savings = new SavingsAccount("John Doe", 500.00, 101, "A12345XYZ");
        savings.displayAccountInfo();
        savings.deposit(200.00);
        savings.withdraw(100.00);
        savings.processPayment(); // Account-specific processing

        System.out.println("----------------------");

        // Create Checking Account
        BankAccount checking = new CheckingAccount("Jane Doe", 1000.00, 102, "B67890XYZ");
        checking.displayAccountInfo();
        checking.withdraw(300.00);
        checking.processPayment();
    }
}