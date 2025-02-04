import java.util.Scanner;

public class App {
    public static void main(String[] args) throws ReservaInvalidaException {
        try (Scanner sc = new Scanner(System.in)) {
            App app = new App();
            GestionClientes gestionClientes = GestionClientes.getGestor();
            GestionReservas gestionReservas = GestionReservas.getGestor();
            app.mostrarMenu(sc, gestionClientes, gestionReservas);
        }
    }

    public void mostrarMenu(Scanner sc, GestionClientes gestionClientes, GestionReservas gestionReservas)
            throws ReservaInvalidaException {
        int option = 0;
        do {
            String menu = """
                    1) Ingresar Cliente
                    2) Buscar Cliente
                    3) Crear Reserva
                    4) Buscar Reservas
                    5) Salir
                    """;
            System.out.println(menu);
            System.out.print("Ingresa una opcion: ");
            option = Integer.parseInt(sc.nextLine());
            String name;
            switch (option) {
                case 1:
                    System.out.println("Ingresar Cliente.");
                    System.out.print("Ingresa el nombre del cliente: ");
                    name = sc.nextLine();
                    gestionClientes.agregarCliente(name);
                    break;
                case 2:
                    try {
                        System.out.println("Buscar Cliente.");
                        System.out.print("Ingresa el id del cliente: ");
                        int id = Integer.parseInt(sc.nextLine());
                        System.out.println(gestionClientes.buscarCliente(id));
                    } catch (ClienteNoEncontradoException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 3:

                    try {
                        System.out.println("Crear Reserva.");
                        System.out.print("Ingresa el id del cliente: ");
                        int id = Integer.parseInt(sc.nextLine());
                        System.out.println("Fecha inicio: ");
                        String fechaInicio = sc.nextLine();
                        System.out.println("Fecha fin: ");
                        String fechaFin = sc.nextLine();
                        gestionReservas.crearReserva(id, fechaInicio, fechaFin, gestionClientes);
                    } catch (ClienteNoEncontradoException | ReservaInvalidaException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        System.out.println("Buscar Reservas.");
                        System.out.print("Ingresa el id del cliente: ");
                        int id = Integer.parseInt(sc.nextLine());
                        gestionReservas.buscarReservas(id, gestionClientes);
                    } catch (ClienteNoEncontradoException | ReservaInvalidaException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                default:
                    break;
            }
        } while (option != 5);

    }
}
