package Strategy;

class DescuentoVIP implements IEstrategiaDescuento {
    @Override
    public double aplicarDescuento(double monto) {
        return monto * 0.90; // 10% de descuento
    }
}