public class Car extends Vehiculo {
    private int numDoors;

    public Car(String brand, String model, double speedMax, int numDoors) {
        super(brand, model, speedMax);
        this.numDoors = numDoors;
    }

    public int getNumDoors() {
        return numDoors;
    }

    public void setNumDoors(int numDoors) {
        this.numDoors = numDoors;
    }

    @Override
    public String toString() {
        return "Car [NumDoors = " + getNumDoors() + ", Brand = " + getBrand()
                + ", Model = " + getModel() + ", SpeedMax = " + getSpeedMax() + "]";
    }

}
