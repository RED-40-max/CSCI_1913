package Java.Bank;

public abstract class Payment {
    protected String accountHolder;

    public Payment(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public abstract boolean processPayment(double amount);

    protected void printReceipt(double amount, String paymentType) {
        System.out.println(accountHolder + " paid $" + amount + " using " + paymentType);
    }
}
