package Exercise_2;

public interface DiscountStrategy {
    double applyDiscount(double price, int quantity, Person person);
}
