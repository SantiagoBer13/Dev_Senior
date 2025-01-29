import Cliente.TipoCliente;
import Factory.Cliente;
import Factory.ClienteFactory;
import Observer.Facturacion;
import Observer.EmailNotificador;
import Singleton.GestorClientes;
import Strategy.ProcesadorDescuentos;

public class Main {
    public static void main(String[] args) {
        // Crear gestor de clientes (Singleton)
        GestorClientes gestor = GestorClientes.getInstancia();

        // Crear clientes con Factory Method
        Cliente cliente1 = ClienteFactory.crearCliente(TipoCliente.REGULAR,  "Juan Perez", "juan@email.com");
        Cliente cliente2 = ClienteFactory.crearCliente(TipoCliente.VIP, "Maria López", "maria@email.com");
        Cliente cliente3 = ClienteFactory.crearCliente(TipoCliente.REGULAR, "Maria López", "maria@email.com");

        // Agregar clientes al gestor
        gestor.agregarCliente(cliente1);
        gestor.agregarCliente(cliente2);

        // Crear el sistema de facturación con Observer
        Facturacion facturacion = new Facturacion();
        facturacion.agregarObservador(new EmailNotificador());

        // Generar facturas con descuentos aplicados
        double monto1 = ProcesadorDescuentos.aplicarDescuento(cliente1, 1000);
        double monto2 = ProcesadorDescuentos.aplicarDescuento(cliente2, 2000);
        double monto3 = ProcesadorDescuentos.aplicarDescuento(cliente3, 2000);

        facturacion.generarFactura(cliente1, monto1);
        facturacion.generarFactura(cliente2, monto2);
        facturacion.generarFactura(cliente3, monto3);
    }
}
