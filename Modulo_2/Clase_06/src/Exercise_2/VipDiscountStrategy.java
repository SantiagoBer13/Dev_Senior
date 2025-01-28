package Exercise_2;

public class VipDiscountStrategy implements DiscountStrategy {

    @Override
    public double applyDiscount(double price, int quantity, Person person) {
        if (person.getMembership().equalsIgnoreCase("VIP")) {
            double total = price * quantity;
            double discount = total * 0.25;
            System.out.printf("%s (VIP) compró %d unidades. Total: %.2f, Descuento (25%%): %.2f, Precio final: %.2f.%n",
                person.getName(), quantity, total, discount, total - discount);
            return total - discount;
        } else {
            System.out.printf("%s no tiene membresía VIP, no se aplica descuento especial.%n", person.getName());
            return price * quantity;
        }
    }

}
