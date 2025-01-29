package Factory;
public class ClienteRegular extends Cliente {

    public ClienteRegular(String nombre, String email) {
        super( nombre, email);
    }

    @Override
    public double obtenerDescuento() {
        return 0.05; // 5% de descuento
    }
    
}
