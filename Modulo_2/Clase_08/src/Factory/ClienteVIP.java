package Factory;
public class ClienteVIP extends Cliente {
    public ClienteVIP( String nombre, String email) {
        super( nombre, email);
    }

    @Override
    public double obtenerDescuento() {
        return 0.10; // 10% de descuento
    }
}