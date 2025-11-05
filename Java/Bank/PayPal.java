package Java.Bank;
public class PayPal extends Payment {
    private String email;
    private boolean validAccount;

    public PayPal(String accountHolder, String email) {
        super(accountHolder);
        this.email = email;
        this.validAccount = true;
    }

    @Override
    public boolean processPayment(double amount) {
        if (validAccount) {
            System.out.println("Payment successful!");
            printReceipt(amount);
            return true;
        } else {
            System.out.println("Invalid account!");
            return false;
        }
    }

    public void invalidateAccount() {
        validAccount = false;
    }

    @Override
    protected void printReceipt(double amount, String paymentType) {
        System.out.println(accountHolder + " paid $" + amount + " using PayPal (" + email + ")");
    }

    // Helper method for compatibility
    protected void printReceipt(double amount) {
        printReceipt(amount, "PayPal");
    }
}
