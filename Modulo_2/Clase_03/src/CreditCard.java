public class CreditCard implements PaymentMethod {

    private Double amount;

    @Override
    public void processPayment(double amount) {
        if (validateAmount(amount)) {
            System.out.println("El pago de $" + amount + " con tarjeta de crédito fue exitoso.");
            this.amount = amount;
        } else {
            System.out.println("Pago rechazado: El monto debe ser mayor a $0.");
            this.amount = null;
        }
    }

    @Override
    public String getDetails() {
        return (amount != null)
            ? String.format("Detalles: Pago realizado con tarjeta de crédito por un monto de $%.2f.", amount)
            : "Detalles: No se realizó ningún pago con tarjeta de crédito.";
    }

    @Override
    public boolean validateAmount(double amount) {
        return amount > 0 ;
    }

}
