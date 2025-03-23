package SBI_IND_CORP;

// Transactions Interface (Defines Standard Banking Operations)
public interface Transactions {
    default void initiatePayment() {
        System.out.println("API call sent to start payment");
    }

    boolean verifyUserID();
    void processPayment();

    static void sendNotification() {
        System.out.println("Notification sent");
    }
}
