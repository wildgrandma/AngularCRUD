import SBI_IND_CORP.BankAccount;

public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount("Kajal Agarwall",1233123,"LanjaModel69");
        bankAccount.displayAccountDetails();
        System.out.println("Validating ID: " + bankAccount.validateID("Aadhar12345")); // true
        System.out.println("Validating ID: " + bankAccount.validateID("LanjaModel69"));
    }
}