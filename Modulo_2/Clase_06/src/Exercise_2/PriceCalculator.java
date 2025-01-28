package Exercise_2;

public class PriceCalculator {
    private DiscountStrategy discountStrategy;

    public PriceCalculator(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public double calculatePrice(double price, int quantity, Person person) {
        return discountStrategy.applyDiscount(price, quantity, person);
    }
}
