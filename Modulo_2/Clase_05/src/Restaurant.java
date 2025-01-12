public class Restaurant {
    Kitchen kitchen;
    Waiter waiter;
    CashRegister cashRegister;

    public Restaurant(){
        this.kitchen = new Kitchen();
        this.waiter = new Waiter();
        this.cashRegister = new CashRegister();
    }

    public void operateRestaurant(){
        this.kitchen.cookDish();
        this.waiter.serve();
        this.cashRegister.processPayment();
    }
}
