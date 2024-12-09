public class Bitcoin implements PaymentMethod {

    private Double amount;

    @Override
    public void processPayment(double amount) {
        if (validateAmount(amount)) {
            System.out.println("El pago de " + amount + " BTC con Bitcoin fue exitoso.");
            this.amount = amount;
        } else {
            System.out.println("Pago rechazado: El monto debe ser mayor o igual a 0.001 BTC.");
            this.amount = null;
        }
    }

    @Override
    public String getDetails() {
        return (amount != null)
            ? String.format("Detalles: Pago realizado con Bitcoin por un monto de %.4f BTC.", amount)
            : "Detalles: No se realizó ningún pago con Bitcoin.";
    }

    @Override
    public boolean validateAmount(double amount) {
        return amount >= 0.001;
    }
    
}
