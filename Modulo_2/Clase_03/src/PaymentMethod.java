public interface PaymentMethod {
    void processPayment(double amount);
    String getDetails();
    boolean validateAmount(double amount);
}
