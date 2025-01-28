import java.util.ArrayList;
import java.util.List;

public class Product implements Subject {

    private List<Observer> observers = new ArrayList<>();
    private int price;
    private String name;

    public Product(String name) {
        this.name = name;
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(price, name);
        }
    }

    public void setPrice(int price) {
        this.price = price;
        notifyObservers();
    }
    
}
