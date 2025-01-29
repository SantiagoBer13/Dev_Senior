package Strategy;
import Factory.Cliente;
import Factory.ClienteVIP;

public class ProcesadorDescuentos {
    public static double aplicarDescuento(Cliente cliente, double monto) {
        IEstrategiaDescuento estrategia;
        if (cliente instanceof ClienteVIP) {
            estrategia = new DescuentoVIP();
        } else {
            estrategia = new DescuentoRegular();
        }
        return estrategia.aplicarDescuento(monto);
    }
}