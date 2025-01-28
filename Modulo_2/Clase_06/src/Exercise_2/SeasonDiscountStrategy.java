package Exercise_2;

public class SeasonDiscountStrategy implements DiscountStrategy {

    @Override
    public double applyDiscount(double price, int quantity, Person person) {
        double total = price * quantity;
        double discount = total * 0.20;
        System.out.printf("%s compró %d unidades. Total: %.2f, Descuento (20%%): %.2f, Precio final: %.2f.%n",
            person.getName(), quantity, total, discount, total - discount);
        return total - discount;
    }

}
