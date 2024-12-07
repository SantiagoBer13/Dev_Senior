import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    static Scanner sc = new Scanner(System.in);
    static List<List<String>> products = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        byte option;
        do {
            showMenu();
            System.out.print("Por favor, ingresa una opción: ");
            option = Byte.parseByte(sc.nextLine());
            switch (option) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    showProducts();
                    break;
                case 3:
                    List<String> productoSearched = searchProduct();
                    if(productoSearched != null){
                        System.out.printf("¡Producto encontrado!%nNombre: %s, Cantidad: %s, Precio: %.2f$.%n", productoSearched.get(0), productoSearched.get(1), Double.parseDouble(productoSearched.get(2)));
                    } else {
                        System.out.println("Lo sentimos, no encontramos ese producto.");
                    }
                    break;
                case 4:
                    updateProduct();
                    break;
                case 5:
                    calculateValueTotalInventario();
                    break;
                case 6:
                    calculaProductMostAndLessExpensive();
                    break;
                case 7:
                    System.out.println("¡Hasta luego! Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, elige una opción válida.");
                    break;
            }
        } while (option != 7);
        sc.close();
    }

    public static void showMenu() {
        String menu = """
                *** Calculadora de Inventario ***
                
                1) Ingresar nuevo producto
                2) Mostrar todos los productos
                3) Buscar producto
                4) Actualizar producto
                5) Calcular el valor total del inventario
                6) Mostrar producto más caro y más barato
                7) Salir
                """;
        System.out.print(menu);
    }

    public static void addProduct() {
        if (products.size() == 100) {
            System.out.println("¡Lo siento! Has alcanzado el límite de productos que puedes agregar.");
        } else {
            System.out.print("Ingresa el nombre del producto: ");
            String name = sc.nextLine();
            System.out.print("Ingresa la cantidad del producto: ");
            String count = sc.nextLine();
            System.out.print("Ingresa el precio del producto (en formato numérico): ");
            String price = sc.nextLine();
            List<String> product = new ArrayList<>();
            product.add(name);
            product.add(count);
            product.add(price);
            products.add(product);
            System.out.println("Producto agregado con éxito.");
        }
    }

    public static void showProducts() {
        if (products.size() > 0) {
            System.out.println("Lista de productos:");
            for (List<String> product : products) {
                System.out.printf("Nombre: %s | Cantidad: %s | Precio: %.2f$.%n", product.get(0), product.get(1), Double.parseDouble(product.get(2)));
            }
        } else {
            System.out.println("No hay productos disponibles en el inventario.");
        }
    }

    public static List<String> searchProduct() {
        System.out.print("Ingresa el nombre del producto que deseas buscar: ");
        String name = sc.nextLine();
        List<String> productoSearched = products.stream()
                .filter(product -> product.get(0).equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
        return productoSearched;
    }

    public static void updateProduct(){
        List<String> productoSearched = searchProduct();
        if(productoSearched != null){
            System.out.printf("Producto encontrado:%nNombre: %s | Cantidad: %s | Precio: %.2f$.%n", productoSearched.get(0), productoSearched.get(1), Double.parseDouble(productoSearched.get(2)));
            int index = products.indexOf(productoSearched);
            System.out.print("Ingresa la nueva cantidad del producto: ");
            String count = sc.nextLine();
            System.out.print("Ingresa el nuevo precio del producto: ");
            String price = sc.nextLine();
            productoSearched.set(1, count);
            productoSearched.set(2, price);
            products.set(index, productoSearched);
            System.out.println("Producto actualizado correctamente.");
        } else {
            System.out.println("No encontramos el producto que buscas.");
        }
    }

    public static void calculateValueTotalInventario(){
        double sum = 0;
        for (List<String> product : products) {
            sum += Integer.parseInt(product.get(1)) * Double.parseDouble(product.get(2));
        }
        System.out.printf("El valor total del inventario es: %.2f$%n", sum);
    }

    public static void calculaProductMostAndLessExpensive(){
        List<String> productMostExpensive = null, productLessExpensive = null;
        Double menor = Double.MAX_VALUE, mayor = 0.0;
        for (List<String> product : products) {
            double price = Double.parseDouble(product.get(2));
            if(price > mayor){
                productMostExpensive = product;
                mayor = price;
            }
            if(price < menor){
                productLessExpensive = product;
                menor = price;
            }
        }
        if (productMostExpensive != null && productLessExpensive != null) {
            System.out.printf("Producto más caro:%nNombre: %s | Cantidad: %s | Precio: %.2f$.%n", productMostExpensive.get(0), productMostExpensive.get(1), Double.parseDouble(productMostExpensive.get(2)));
            System.out.printf("Producto más barato:%nNombre: %s | Cantidad: %s | Precio: %.2f$.%n", productLessExpensive.get(0), productLessExpensive.get(1), Double.parseDouble(productLessExpensive.get(2)));
        } else {
            System.out.println("No se han encontrado productos suficientes para comparar precios.");
        }
    }
}