import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Exercise1 {

    static  List<String[]> ventas = new ArrayList<>();
    static Map<String, Integer> numeroVentas = new HashMap<>();
    static Scanner sc = new Scanner(System.in);
    Function<String, Integer> toInt = Integer::parseInt;

    public static void main(String[] args) {
        System.out.println("Análisis de Ventas de una Tienda");
        ingresarVentas();

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
            System.out.println(menu);
            String option = sc.nextLine();
            switch (option) {
                case "1" -> calcularIngresoTotal();
                case "2" -> contarVentasPorProducto();
                case "3" -> filtrarVentasMayores();
                case "4" -> obtenerProductoVendido();
                case "5" -> ingresarVentas();
                case "6" -> {
                    System.out.println("Saliendo...");
                    sc.close();
                    return;
                }
                default -> System.out.println("Opción inválida. Intenta de nuevo.");
            }
        }
    }

    private static void ingresarVentas() {
        System.out.println("Ingresa el registro 'producto,cantidad,precio_unitario'. Escribe 'stop' para terminar:");
        while (true) {
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("stop"))
                break;

            String[] registro = input.split(",");
            if (registro.length == 3) {
                ventas.add(registro);
            } else {
                System.out.println("Registro inválido. Debe tener el formato 'producto,cantidad,precio_unitario'.");
            }
        }
    }

    // public static double calculateIngresoTotal(List<String[]> ventas){
    // double ingresoTotal = 0;
    // for (String[] venta : ventas) {
    // ingresoTotal += Double.parseDouble(venta[1]) * Double.parseDouble(venta[2]);
    // }
    // return ingresoTotal;
    // }

    private static void calcularIngresoTotal() {
        double ingresoTotal = ventas.stream()
                .mapToDouble(venta -> Double.parseDouble(venta[1]) * Double.parseDouble(venta[2]))
                .sum();
        System.out.printf("Ingreso total generado por las ventas: %.2f.%n", ingresoTotal);
    }

    // public static void contarVentasPorProducto(){
    // numeroVentas = new HashMap<>();
    // for (String[] venta : ventas) {
    // int cantidad = Integer.parseInt(venta[1]);
    // if(numeroVentas.containsKey(venta[0])){
    // cantidad += numeroVentas.get(venta[0]);
    // numeroVentas.put(venta[0], cantidad);
    // }else{
    // numeroVentas.put(venta[0], cantidad);
    // }
    // }
    // }

    public static void contarVentasPorProducto() {
        numeroVentas = ventas.stream()
                .collect(Collectors.toMap(
                        venta -> venta[0],
                        venta -> Integer.parseInt(venta[1]),
                        Integer::sum));
        for (Map.Entry<String, Integer> entry : numeroVentas.entrySet()) {
            System.out.println("Nombre: " + entry.getKey() + " | Cantidad: " + entry.getValue());
        }
    }

    // public static void filterVentasMayores(int monto){
    // for (String[] venta : ventas) {
    // int ingresoTotal = Integer.parseInt( venta[1]) * Integer.parseInt(venta[2]);
    // if(ingresoTotal > monto){
    // System.out.printf("Nombre: %s | Ingreso Total: %d.%n", venta[0],
    // ingresoTotal);
    // }
    // }
    // }

    public static void filtrarVentasMayores() {

        while (true) {
            System.out.print("Ingresa el monto: ");
            int monto = Integer.parseInt(sc.nextLine());
            if (monto > 0) {
                ventas.stream()
                        .filter(venta -> Integer.parseInt(venta[1]) * Integer.parseInt(venta[2]) > monto)
                        .forEach(venta -> {
                            int ingresoTotal = Integer.parseInt(venta[1]) * Integer.parseInt(venta[2]);
                            System.out.printf("Nombre: %s | Ingreso Total: %d.%n", venta[0], ingresoTotal);
                        });
                break;
            } else {
                System.out.println("Ingresa un monto positivo.");
            }

        }

    }

    // public static void obtenerProductoVendido(){
    // contarVentasProducto();
    // int max = 0, count = 0;
    // String data = "";
    // for (Map.Entry<String, Integer> venta : numeroVentas.entrySet()) {
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

    public static void obtenerProductoVendido() {
        contarVentasPorProducto();

        int max = numeroVentas.values().stream().max(Integer::compare).orElse(0);

        List<Map.Entry<String, Integer>> productosMasVendidos = numeroVentas.entrySet().stream()
                .filter(entry -> entry.getValue() == max)
                .toList();

        String mensaje = productosMasVendidos.stream()
                .map(entry -> String.format("Nombre: %s | Cantidad: %d", entry.getKey(), entry.getValue()))
                .collect(Collectors.joining(", "));

        if (productosMasVendidos.size() == 1) {
            System.out.printf("Producto más vendido:%n%s%n", mensaje);
        } else {
            System.out.printf("Productos más vendidos:%n%s%n", mensaje);
        }
    }
}