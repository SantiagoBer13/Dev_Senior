public class App {
    public static void main(String[] args) throws Exception {
        Product product = new Product("PIZZA");
        Product product2 = new Product("HAMBURGUER");
        Observer client1 = new Customer("Client 1");
        Observer client2 = new Customer("Client 2");
        Observer client3 = new Customer("Client 3");
        product.addObserver(client1);
        product.addObserver(client3);
        product2.addObserver(client2);
        product2.addObserver(client3);
        product.setPrice(1000);
        product2.setPrice(1600);
    }
}
