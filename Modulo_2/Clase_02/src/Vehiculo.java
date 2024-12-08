public class Vehiculo {
    private String brand;
    private String model;
    private double speedMax;

    public Vehiculo(String brand, String model, double speedMax) {
        this.brand = brand;
        this.model = model;
        this.speedMax = speedMax;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getSpeedMax() {
        return speedMax;
    }

    public void setSpeedMax(double speedMax) {
        this.speedMax = speedMax;
    }

}
