package Exercise_1;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Inventario inventario = Inventario.getInventario();
        try (Scanner sc = new Scanner(System.in)) {
            App app = new App();
            app.mostrarMenu(sc, inventario);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void mostrarMenu(Scanner sc, Inventario inventario) throws CantidadInvalidaException {
        int option;
        do {
            String menu = """
                    *** Calculadora de Inventario ***

                    1) Ingresar nuevo producto
                    2) Mostrar todos los productos
                    3) Buscar producto
                    4) Actualizar producto
                    5) Eliminar producto
                    6) Salir
                    """;
            System.out.println(menu);
            System.out.print("Ingresa una opción: ");
            option = Integer.parseInt(sc.nextLine());
            String producto;
            int cantidad;
            switch (option) {
                case 1:
                    System.out.println("Ingresar nuevo producto.");
                    System.out.print("Ingrese el nombre del producto: ");
                    producto = sc.nextLine();
                    System.out.print("Ingrese la cantidad del producto: ");
                    cantidad = Integer.parseInt(sc.nextLine());
                    inventario.agregarProducto(producto, cantidad);
                    break;
                case 2:
                    System.out.println("Mostrar todos los productos.");
                    inventario.mostrarInventario();
                    break;
                case 3:
                    try {
                        System.out.println("Buscar producto.");
                        System.out.print("Ingrese el nombre del producto a buscar: ");
                        producto = sc.nextLine();
                        inventario.buscarProducto(producto);
                    } catch (ProductoNoEncontradoException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        System.out.println("Actualizar producto.");
                        System.out.print("Ingrese el nombre del producto a actualizar: ");
                        producto = sc.nextLine();
                        System.out.print("Ingrese la nueva cantidad del producto: ");
                        cantidad = Integer.parseInt(sc.nextLine());
                        inventario.actualizarCantidad(producto, cantidad);
                    } catch (ProductoNoEncontradoException | CantidadInvalidaException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    try {
                        System.out.println("Eliminar producto.");
                        System.out.print("Ingrese el nombre del producto a eliminar: ");
                        producto = sc.nextLine();
                        inventario.eliminarProducto(producto);
                    } catch (ProductoNoEncontradoException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción inválida. Intenta de nuevo.");
                    break;
            }

        } while (option != 6);
    }
}