public class Customer implements Observer {

    private String name;

    public Customer(String name) {
        this.name = name;
    }

    @Override
    public void update(int price, String productName) {
        System.out.printf("Cliente %s: El precio del producto '%s' cambió a %d.%n", name, productName, price);
    }
}
