package Strategy;

class DescuentoRegular implements IEstrategiaDescuento {
    @Override
    public double aplicarDescuento(double monto) {
        return monto * 0.95; // 5% de descuento
    }
}