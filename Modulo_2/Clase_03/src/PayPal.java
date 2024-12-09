public class PayPal implements PaymentMethod {

    private Double amount;

    @Override
    public void processPayment(double amount) {
        if (validateAmount(amount)) {
            System.out.println("El pago de $" + amount + " con PayPal fue exitoso.");
            this.amount = amount;
        } else {
            System.out.println("Pago rechazado: El monto debe estar entre $1 y $10,000.");
            this.amount = null;
        }
    }

    @Override
    public String getDetails() {
        return (amount != null)
            ? String.format("Detalles: Pago realizado con PayPal por un monto de $%.2f.", amount)
            : "Detalles: No se realizó ningún pago con PayPal.";
    }

    @Override
    public boolean validateAmount(double amount) {
        return amount >= 1 && amount < 10000;
    }

}
