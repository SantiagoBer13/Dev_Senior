package Exercise_2;

public class VolumeDiscountStrategy implements DiscountStrategy {

    @Override
    public double applyDiscount(double price, int quantity, Person person) {
        if (quantity > 9) {
            double total = price * quantity;
            double discount = total * 0.15;
            System.out.printf("%s compró %d unidades. Total: %.2f, Descuento (15%%): %.2f, Precio final: %.2f.%n",
                person.getName(), quantity, total, discount, total - discount);
            return total - discount;
        } else {
            System.out.printf("%s intentó comprar %d unidades, pero el descuento por volumen requiere más de 10 unidades.%n",
                person.getName(), quantity);
            return price * quantity;
        }
    }
}
