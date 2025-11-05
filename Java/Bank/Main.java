package Java.Bank;
public class Main {
    public static void main(String[] args) {
        CreditCard cc = new CreditCard("John Doe", "1234567890123456", 5000);
        PayPal pp = new PayPal("Jane Smith", "jane@email.com");

        cc.processPayment(300);
        pp.processPayment(300);

        pp.invalidateAccount();
        pp.processPayment(300);
    }
}
