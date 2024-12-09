public class BankTransfer implements PaymentMethod {

    private Double amount;

    @Override
    public void processPayment(double amount) {
        if (validateAmount(amount)) {
            System.out.println("El pago de $" + amount + " mediante transferencia bancaria fue exitoso.");
            this.amount = amount;
        } else {
            System.out.println("Pago rechazado: El monto debe ser mayor o igual a $10.");
            this.amount = null;
        }
    }

    @Override
    public String getDetails() {
        return (amount != null)
            ? String.format("Detalles: Pago realizado mediante transferencia bancaria por un monto de $%.2f.", amount)
            : "Detalles: No se realizó ningún pago mediante transferencia bancaria.";
    }

    @Override
    public boolean validateAmount(double amount) {
        return amount >= 10;
    }

}
