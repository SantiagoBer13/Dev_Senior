public class App {
    public static void main(String[] args) throws Exception {
        PaymentMethod[] paymentMethods = {
            new CreditCard(),
            new PayPal(),
            new BankTransfer(),
            new Bitcoin(),
            new GiftCard()
        };
        String[] clientes = {"Diego", "Samuel", "Luisa", "Ana", "Carlos"};
        double[] amounts = {20000, 8000, 1, 0.005, 450};

        for (int i = 0; i < paymentMethods.length; i++) {
            System.out.println("Cliente: " + clientes[i]);
            paymentMethods[i].processPayment(amounts[i]);
            System.out.println(paymentMethods[i].getDetails());
            System.out.println("---------------------------------");
        }
    }
}
