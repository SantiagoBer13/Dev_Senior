import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
 * Documentación de Comparator: https://docs.oracle.com/javase/8/docs/api/java/util/Comparator.html
 * 
 * Instrucciones para Ingresar Datos:
 * - El programa permite registrar facturas con el formato: 'numero_factura,cliente,monto_total,iva'.
 * - Ejemplo de registro válido: 'F001,Juan Perez,1000,19'.
 *     - numero_factura: Identificador único de la factura.
 *     - cliente: Nombre del cliente.
 *     - monto_total: Monto base de la factura sin IVA.
 *     - iva: Porcentaje de IVA aplicado.
 * - Para detener la entrada de registros, escribe 'stop'.
 * - Si un registro no cumple con el formato, se mostrará un mensaje de error indicando que el formato es inválido.
 */

public class Exercise3 {
    static List<String[]> bills = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static Map<String, Double> clientMontoTotal = new HashMap<>();
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
        String option;
        while (true) {
            System.out.print(menu);
            option = verifyBills() ? sc.nextLine() : "5";
 
            switch (option) {
                case "1" -> calculateMontoWithIva();
                case "2" -> totalCustomerIncome();
                case "3" -> filterBillsHigher();
                case "4" -> customerMajorIncomeTotal();
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

    public static void totalCustomerIncome() {
        clientMontoTotal = bills.stream()
            .collect(Collectors.toMap(
                    client -> client[1], 
                    client -> {  
                        double base = Double.parseDouble(client[2]); 
                        double porcentaje = Double.parseDouble(client[3]);
                        return base + (base * porcentaje / 100); 
                    },
                    Double::sum));

        System.out.println("\nIngreso Total por Cliente:\n");
        for (Map.Entry<String, Double> entry : clientMontoTotal.entrySet()) {
            System.out.println("Nombre: " + entry.getKey() + " | Monto Total: " + entry.getValue());
        }
    }

    public static void filterBillsHigher() {
        while (true) {
            System.out.print("Ingresa el valor: ");
            Double value = toDouble.apply(sc.nextLine());
            if (value > 0) {
                System.out.printf("%nFacturas Mayores a %f:%n",value);
                bills.stream()
                    .filter(row -> {
                        double base = Double.parseDouble(row[2]); 
                        double percentage = Double.parseDouble(row[3]);
                        double montoTotal = base + (base * percentage / 100);
                        return montoTotal > value;
                    })
                    .forEach(bill -> {
                        double base = Double.parseDouble(bill[2]);
                        double percentage = Double.parseDouble(bill[3]);
                        double montoTotal = base + (base * percentage / 100);
                        System.out.printf("Factura: %s, Nombre del Cliente: %s, Monto: %.2f, IVA: %.2f%%, Monto total con IVA: %.2f.%n", 
                            bill[0], bill[1], base, percentage, montoTotal);
                    });
                break;
            } else {
                System.out.println("Ingresa una calificación positiva.");
            }
        }
    }

    public static void customerMajorIncomeTotal() {
        Map.Entry<String, Double> clienteMaxIngresoTotal = clientMontoTotal.entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .get();

        System.out.printf("\nCliente con el Mayor Ingreso Total:%nCliente :%n%s | Ingreso Total: %.2f%n",
        clienteMaxIngresoTotal.getKey(), clienteMaxIngresoTotal.getValue());
    }

    public static boolean verifyBills(){
        if (bills.isEmpty()) {
            System.out.println("No hay facturas registradas. Por favor, ingresa facturas primero.");
            return false;
        }
        return true;
    }
}