import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Exercise1 {

    static List<String[]> ventas = new ArrayList<>();
    static Map<String, Integer> numeroVentas = new HashMap<>();

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Análisis de Ventas de una Tienda");
        String[] registro;
        String option;
        System.out.println(
                "Ingresa el registro 'producto,cantidad,precio_unitario', Escribe 'stop' para terminar: ");
        do {
            option = sc.nextLine();
            if (option.equalsIgnoreCase("stop")) {
                String menu = """
                        Menú
                        1) Calcular el Ingreso Total.
                        2) Contar Ventas por Producto.
                        3) Filtrar Ventas Mayores a un Monto Específico.
                        4) Obtener el Producto Más Vendido.
                        5) Ingresar mas productos.
                        6) Salir.
                        """;
                do {
                    System.out.println(menu);
                    option = sc.nextLine();
                    switch (option) {
                        case "1":
                            System.out.println();
                            double ingresoTotal = calculateIngresoTotal();
                            System.out.printf("Ingreso total generado por las ventas: %.2f.%n", ingresoTotal);
                            break;
                        case "2":
                            System.out.println("\nContar Ventas por Producto");
                            contarVentasProducto();
                            for (Map.Entry<String, Integer> entry : numeroVentas.entrySet()) {
                                System.out.println("Nombre: " + entry.getKey() + " | Cantidad: " + entry.getValue());
                            }
                            break;
                        case "3":
                            System.out.println("Ingresa el monto");
                            int monto = Integer.parseInt(sc.nextLine());
                            filterVentasMayores(monto);
                            break;
                        case "4":
                            obtenerProductoVendido();
                            break;
                        case "5":
                            System.out.println(
                                    "IIngresa el registro 'producto,cantidad,precio_unitario'. Escribe 'stop' para terminar:");
                            break;
                        case "6":
                            System.out.println("Saliendo");
                            break;
                        default:
                            System.out.println("Ingresa una opción valida.");
                            break;
                    }

                } while (!option.equalsIgnoreCase("5") && !option.equalsIgnoreCase("6"));
                if (option.equalsIgnoreCase("6")) {
                    break;
                }
            }
            if (!option.equalsIgnoreCase("5")) {
                registro = option.split(",");
                ventas.add(registro);
            }
        } while (true);

        sc.close();

    }

    // public static double calculateIngresoTotal(List<String[]> ventas){
    // double ingresoTotal = 0;
    // for (String[] venta : ventas) {
    // ingresoTotal += Double.parseDouble(venta[1]) * Double.parseDouble(venta[2]);
    // }
    // return ingresoTotal;
    // }

    public static double calculateIngresoTotal() {
        return ventas.stream()
                .mapToDouble(venta -> Double.parseDouble(venta[1]) * Double.parseDouble(venta[2]))
                .sum();
    }

    // public static void contarVentasProducto(){
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

    public static void contarVentasProducto() {
        numeroVentas = ventas.stream()
                .collect(Collectors.toMap(
                        venta -> venta[0],
                        venta -> Integer.parseInt(venta[1]),
                        Integer::sum));
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

    public static void filterVentasMayores(int monto) {
        ventas.stream()
                .filter(venta -> Integer.parseInt(venta[1]) * Integer.parseInt(venta[2]) > monto)
                .forEach(venta -> {
                    int ingresoTotal = Integer.parseInt(venta[1]) * Integer.parseInt(venta[2]);
                    System.out.printf("Nombre: %s | Ingreso Total: %d.%n", venta[0], ingresoTotal);
                });
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
        contarVentasProducto();

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