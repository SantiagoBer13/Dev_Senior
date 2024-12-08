public class Motorbike extends Vehiculo {
    private boolean hasSidecar;

    public Motorbike(String brand, String model, double speedMax, boolean hasSidecar) {
        super(brand, model, speedMax);
        this.hasSidecar = hasSidecar;
    }

    public boolean isHasSidecar() {
        return hasSidecar;
    }

    public void setHasSidecar(boolean hasSidecar) {
        this.hasSidecar = hasSidecar;
    }

    @Override
    public String toString() {
        return "Motorbike [HasSidecar = " + isHasSidecar() + ", Brand = "
                + getBrand() + ", Model = " + getModel() + ", SpeedMax = " + getSpeedMax() + "]";
    }

}
