import java.util.ArrayList;
import java.util.List;

public class GestionReservas {

    private static GestionReservas gestionReservas;
    private List<List<String>> reservas = new ArrayList<>();

    private GestionReservas() {
    };

    public static GestionReservas getGestor() {
        if (gestionReservas == null) {
            gestionReservas = new GestionReservas();
        }
        return gestionReservas;
    }

    public void crearReserva(int clienteId, String fechaInicio, String fechaFin, GestionClientes gestionClientes)
            throws ReservaInvalidaException {
        try {
            String id = gestionClientes.buscarCliente(clienteId);
            List<String> reserva = new ArrayList<>();
            reserva.add(id);
            if (fechaInicio.compareTo(fechaFin) > 0) {
                throw new ReservaInvalidaException("La fecha de inicio no puede ser posterior a la de fin");
            }
            reserva.add(fechaInicio);
            reserva.add(fechaFin);
            reservas.add(reserva);
            System.out.println("Reserva creada con exito");
        } catch (ClienteNoEncontradoException e) {
            throw new ReservaInvalidaException("El cliente no existe");
        }
    }

    public void buscarReservas(int clienteId, GestionClientes gestionClientes) throws ReservaInvalidaException {
        try {
            String nombre = gestionClientes.buscarCliente(clienteId);
            for (List<String> reserva : reservas) {
                if (reserva.get(0).equals(nombre)) {
                    System.out.println(reserva);
                }
            }
        } catch (ClienteNoEncontradoException e) {
            throw new ReservaInvalidaException("El cliente no existe");
        }

    }

}
