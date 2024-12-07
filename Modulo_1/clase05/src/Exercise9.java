import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Exercise9 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Queue<String> clients = new LinkedList<>();

        int option;
        String menu = """
                Simulación de una cola de clientes en un banco
                1) Agregar cliente.
                2) Atender cliente.
                0) Salir.
                """;
        do {
            System.out.print(menu);
            System.out.print("Ingresa una opción: ");
            option = Integer.parseInt(input.nextLine());

            switch (option) {
                case 1:
                    addClient(clients, input);
                    showClients(clients);
                    break;
                case 2:
                    showClients(clients);
                    atendClient(clients, input);
                    showClients(clients);
                    break;
                case 0:
                    System.out.println("Saliendo.");
                    break;  
                default:
                    break;
            }
        } while (option != 0);
        input.close();
    }

    public static void addClient(Queue<String> clients, Scanner input){
        System.out.println();
        System.out.print("Ingresa el nombre del cliente: ");
        String client = input.nextLine();
        clients.offer(client);
        System.out.println("Cliente agregado.");
    }

    public static void atendClient(Queue<String> clients, Scanner input){
        String client = clients.poll();
        if (client == null) {
            System.out.println("\nNo hay clientes por atender.\n");
        } else {
            System.out.printf("Cliente atendido: %s.%n%n", client);
        }
    }

    public static void showClients(Queue<String> clients){
        if(clients.size() > 0){
            System.out.println("\nEstado de clientes por atender:");
            int i = 1;
            for (String client : clients) {
                System.out.printf("%d) %s.%n", i++, client);
            }
            System.out.println();
        }
    }
}
