import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

// Documentación de Stream: https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html#max-java.util.Comparator-

/*
 * Documentación sobre cómo ingresar los datos:
 *
 * El programa permite registrar las ventas de productos de una tienda. Los datos deben ingresarse 
 * en el formato específico de la siguiente manera:
 *
 * - En cada línea, ingresa un registro con el formato: "producto,cantidad,precio_unitario".
 *   - "producto": el nombre del producto (texto).
 *   - "cantidad": el número de unidades vendidas (número entero).
 *   - "precio_unitario": el precio por unidad del producto (número decimal).
 * 
 * Ejemplos de entradas válidas:
 * - "camisa,2,20.00" -> Producto: Camisa, Cantidad: 2, Precio unitario: 20.00
 * - "pantalon,1,35.50" -> Producto: Pantalón, Cantidad: 1, Precio unitario: 35.50
 * - "zapatos,3,50.00" -> Producto: Zapatos, Cantidad: 3, Precio unitario: 50.00
 *
 * Ingresar cada registro de ventas **en una línea separada**, presionando **Enter** después de cada uno.
 *
 * Ejemplo:
 * - Primero, ingresa "camisa,2,20.00" y presiona **Enter**.
 * - Luego, ingresa "pantalon,1,35.50" y presiona **Enter**.
 * - Luego, ingresa "zapatos,3,50.00" y presiona **Enter**.
 *
 * Puedes agregar tantos registros como desees. Para terminar de ingresar datos, escribe **'stop'** y presiona **Enter**.
 *
 * Ejemplo de múltiples registros válidos:
 * "camisa,2,20.00"
 * "pantalon,1,35.50"
 * "zapatos,3,50.00"
 * "camisa,1,20.00"
 * "pantalon,2,35.50"
 * 
 * Si se ingresa un formato incorrecto, el programa mostrará un mensaje de error y pedirá que se ingrese el registro nuevamente con el formato correcto.
 * 
 * Recuerda: una vez ingresados todos los productos, puedes terminar el proceso escribiendo 'stop'.
 */

public class Exercise1 {

    static List<String[]> sales = new ArrayList<>();
    static Map<String, Integer> numSales = new HashMap<>();
    static Scanner sc = new Scanner(System.in);
    Function<String, Integer> toInt = Integer::parseInt;

    public static void main(String[] args) {
        System.out.println("Análisis de Ventas de una Tienda");
        addSales();

        String menu = """

                Menú
                1) Calcular el Ingreso Total.
                2) Contar Ventas por Producto.
                3) Filtrar Ventas Mayores a un Monto Específico.
                4) Obtener el Producto Más Vendido.
                5) Ingresar más productos.
                6) Salir.
                """;

        while (true) {
            System.out.print(menu);
            String option = sc.nextLine();
            switch (option) {
                case "1" -> calIncomeTotal();
                case "2" -> showSalesByProducto();
                case "3" -> filterHigherSales();
                case "4" -> getMostPurchasedProduct();
                case "5" -> addSales();
                case "6" -> {
                    System.out.println("Saliendo...");
                    sc.close();
                    return;
                }
                default -> System.out.println("Opción inválida. Intenta de nuevo.");
            }
        }
    }

    private static void addSales() {
        System.out.println("Ingresa el registro 'producto,cantidad,precio_unitario'. Escribe 'stop' para terminar:");
        while (true) {
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("stop"))
                break;

            String[] row = input.split(",");
            if (row.length == 3) {
                sales.add(row);
            } else {
                System.out.println("Registro inválido. Debe tener el formato 'producto,cantidad,precio_unitario'.");
            }
        }
    }

    // public static double calculateIngresoTotal(List<String[]> sales){
    // double incomeTotal = 0;
    // for (String[] sale : sales) {
    // incomeTotal += Double.parseDouble(sale[1]) * Double.parseDouble(sale[2]);
    // }
    // return incomeTotal;
    // }

    private static void calIncomeTotal() {
        double incomeTotal = sales.stream()
                .mapToDouble(sale -> Double.parseDouble(sale[1]) * Double.parseDouble(sale[2]))
                .sum();
        System.out.printf("%nIngreso total generado por las ventas: %.2f.%n", incomeTotal);
    }

    // public static void countSalesByProducto(){
    // numSales = new HashMap<>();
    // for (String[] venta : sales) {
    // int cantidad = Integer.parseInt(venta[1]);
    // if(numSales.containsKey(venta[0])){
    // cantidad += numSales.get(venta[0]);
    // numSales.put(venta[0], cantidad);
    // }else{
    // numSales.put(venta[0], cantidad);
    // }
    // }
    // }

    public static void countSalesByProduct() {
        numSales = sales.stream()
                .collect(Collectors.toMap(
                        sale -> sale[0],
                        sale -> Integer.parseInt(sale[1]),
                        Integer::sum));
    }

    public static void showSalesByProducto(){
        countSalesByProduct();
        System.out.println();
        if(numSales.size() > 0){
            for (Map.Entry<String, Integer> sales : numSales.entrySet()) {
                System.out.println("Nombre: " + sales.getKey() + " | Cantidad: " + sales.getValue());
            }
        }else{
            System.out.println("No hay ventas registradas.");
        }
    }

    // public static void filterVentasMayores(int monto){
    // for (String[] venta : sales) {
    // int ingresoTotal = Integer.parseInt( venta[1]) * Integer.parseInt(venta[2]);
    // if(ingresoTotal > monto){
    // System.out.printf("Nombre: %s | Ingreso Total: %d.%n", venta[0],
    // ingresoTotal);
    // }
    // }
    // }

    public static void filterHigherSales() {
        System.out.println();
        while (true) {
            if(sales.size() > 0){
                System.out.print("Ingresa el monto: ");
                Double monto = Double.parseDouble(sc.nextLine());
                if (monto > 0) {
                    sales.stream()
                            .filter(sale -> Double.parseDouble(sale[1]) * Double.parseDouble(sale[2]) > monto)
                            .forEach(sale -> {
                                Double incomeTotal = Double.parseDouble(sale[1]) * Double.parseDouble(sale[2]);
                                System.out.printf("Nombre: %s | Ingreso Total: %.2f.%n", sale[0], incomeTotal);
                            });
                    break;
                } else {
                    System.out.println("Ingresa un monto positivo.");
                }
            }else{
                System.out.println("No hay ventas registradas.");
                break;
            }
        }
    }

    // public static void getMostPurchasedProduct(){
    // contarVentasProducto();
    // int max = 0, count = 0;
    // String data = "";
    // for (Map.Entry<String, Integer> venta : numSales.entrySet()) {
    // if(venta.getValue() >= max){
    // if(venta.getValue() > max && count > 0){
    // data = "";
    // count = 0;
    // }
    // data += "Nombre: " + venta.getKey() + " | Cantidad: " + venta.getValue() + ",
    // ";
    // max = venta.getValue();
    // count++;
    // }
    // }
    // if(count == 1){
    // System.out.printf("Producto mas vendido: %n%s%n", data);
    // }else if(count == 2){
    // System.out.printf("Productos mas vendidos: %n%s%n", data);
    // }
    // }

    public static void getMostPurchasedProduct() {
        countSalesByProduct();
        if (sales.size() > 0) {
            int max = numSales.values().stream().max(Integer::compare).get();
    
            List<Map.Entry<String, Integer>> productosMorePurchased = numSales.entrySet().stream()
                    .filter(sale -> sale.getValue() == max)
                    .toList();
    
            String message = productosMorePurchased.stream()
                    .map(sale -> String.format("Nombre: %s | Cantidad: %d", sale.getKey(), sale.getValue()))
                    .collect(Collectors.joining(", "));
    
            if (productosMorePurchased.size() == 1) {
                System.out.printf("Producto más vendido:%n%s%n", message);
            } else {
                System.out.printf("Productos más vendidos:%n%s%n", message);
            }
        }else{
            System.out.println("No hay ventas registradas.");
        }
    }
}