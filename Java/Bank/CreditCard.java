package Java.Bank;

public class CreditCard extends Payment {
    private String cardNumber;
    private double creditLimit;

    public CreditCard(String accountHolder, String cardNumber, double creditLimit) {
        super(accountHolder);
        this.cardNumber = cardNumber;
        this.creditLimit = creditLimit;
    }


    public boolean processPayment(double amount) {
        if (amount <= creditLimit) {
            System.out.println("Payment successful!");
            printReceipt(amount);
            return true;
        } else {
            System.out.println("Payment failed, over credit limit!");
            return false;
        }
    }


    protected void printReceipt(double amount, String paymentType) {
        super.printReceipt(amount, paymentType);

    }


    protected void printReceipt(double amount) {
        printReceipt(amount, "Credit Card");
    }
}
