package Observer;
import java.util.ArrayList;
import java.util.List;

import Factory.Cliente;

public class Facturacion {
    private List<IObservador> observadores = new ArrayList<>();

    public void agregarObservador(IObservador o) {
        observadores.add(o);
    }

    public void generarFactura(Cliente cliente, double monto) {
        System.out.println("ID Cliente: " + cliente.getId() + " Factura generada para " + cliente.getNombre() + " por $" + monto);
        notificar("a " + cliente.getEmail() + ": Factura generada para " + cliente.getNombre() + " por $" + monto);
    }

    private void notificar(String mensaje) {
        for (IObservador o : observadores) {
            o.actualizar(mensaje);
        }
    }
}