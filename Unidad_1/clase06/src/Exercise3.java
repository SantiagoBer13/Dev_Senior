import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Exercise3 {
    static List<String[]> bills = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static Map<String, Double> clienteMontoTotal = new HashMap<>();
    static Function<String, Double> toDouble = Double::parseDouble;
    public static void main(String[] args) {
        System.out.println("\nAnálisis de Facturas de una Empresa\n");
        addBill();
        String menu = """

                Menú
                1) Calcular el Monto Total con IVA.
                2) Calcular el Ingreso Total por Cliente.
                3) Filtrar Facturas Mayores a un Valor Específico
                4) Obtener el Cliente con el Mayor Ingreso Total.
                5) Ingresar más facturas.
                6) Salir.
                """;

        while (true) {
            System.out.print(menu);
            String option = sc.nextLine();
            switch (option) {
                case "1" -> calculateMontoWithIva();
                case "2" -> ingresoTotalCliente();
                case "3" -> filtrarBillsMayores();
                case "4" -> clienteMayorIngresoTotal();
                case "5" -> addBill();
                case "6" -> {
                    System.out.println("Saliendo...");
                    sc.close();
                    return;
                }
                default -> System.out.println("Opción inválida. Intenta de nuevo.");
            }
        }
    }

    private static void addBill() {
        System.out.println("Ingresa el registro 'numero_factura,cliente,monto_total,iva'. Escribe 'stop' para terminar:");
        while (true) {
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("stop"))
                break;

            String[] row = input.split(",");
            if (row.length == 4) {
                bills.add(row);
            } else {
                System.out.println("Registro inválido. Debe tener el formato 'numero_factura,cliente,monto_total,iva'.");
            }
        }
    }

    public static void calculateMontoWithIva(){
        System.out.println("\nMonto Total con IVA\n");
        bills.stream().forEach((bill) -> {
            Double monto = toDouble.apply(bill[2]);
            Double iva = toDouble.apply(bill[3]);
            Double montoTotal = monto + (monto * iva / 100);
            System.out.printf("Factura: %s, Nombre del Cliente: %s, Monto: %s, IVA: %s%%, Monto total con IVA: %.2f.%n", bill[0], bill[1], bill[2], bill[3], montoTotal);
        });
    }

    public static void ingresoTotalCliente() {
        clienteMontoTotal = bills.stream()
            .collect(Collectors.toMap(
                    cliente -> cliente[1], 
                    cliente -> {  
                        double base = Double.parseDouble(cliente[2]); 
                        double porcentaje = Double.parseDouble(cliente[3]);
                        return base + (base * porcentaje / 100); 
                    },
                    Double::sum));

        System.out.println("\nIngreso Total por Cliente:\n");
        for (Map.Entry<String, Double> entry : clienteMontoTotal.entrySet()) {
            System.out.println("Nombre: " + entry.getKey() + " | Monto Total: " + entry.getValue());
        }
    }

    public static void filtrarBillsMayores() {
        while (true) {
            System.out.print("Ingresa el valor: ");
            Double value = toDouble.apply(sc.nextLine());
            if (value > 0) {
                System.out.printf("%nFacturas Mayores a %f:%n",value);
                bills.stream()
                    .filter(row -> {
                        double base = Double.parseDouble(row[2]); 
                        double porcentaje = Double.parseDouble(row[3]);
                        double montoTotal = base + (base * porcentaje / 100);
                        return montoTotal > value;
                    })
                    .forEach(bill -> {
                        double base = Double.parseDouble(bill[2]);
                        double porcentaje = Double.parseDouble(bill[3]);
                        double montoTotal = base + (base * porcentaje / 100);
                        System.out.printf("Factura: %s, Nombre del Cliente: %s, Monto: %.2f, IVA: %.2f%%, Monto total con IVA: %.2f.%n", 
                            bill[0], bill[1], base, porcentaje, montoTotal);
                    });
                break;
            } else {
                System.out.println("Ingresa una calificación positiva.");
            }
        }
    }

    public static void clienteMayorIngresoTotal() {
        Map.Entry<String, Double> clienteMaxIngresoTotal = clienteMontoTotal.entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .get();

        System.out.printf("n Cliente con el Mayor Ingreso Total:%nCliente :%n%s | Ingreso Total: %.2f%n",
        clienteMaxIngresoTotal.getKey(), clienteMaxIngresoTotal.getValue());
    }
}