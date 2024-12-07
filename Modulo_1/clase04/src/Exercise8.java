import java.util.Scanner;

public class Exercise8 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String menu = """
                
                Cálculo de Áreas
                1) Área de un Círculo.
                2) Área de un Cuadrado.
                3) Área de un Triángulo.
                4) Salir.
                """;
        int opcion;
        do {
            System.out.print(menu);
            System.out.print("Ingresa una opción: ");
            opcion = Integer.parseInt(input.nextLine());
            double area;
            
            switch (opcion) {
                case 1:
                    System.out.print("Ingresa el radio del círculo: ");
                    double radio = Double.parseDouble(input.nextLine());
                    area = calcularAreaCirculo(radio);
                    System.out.printf("El área del círculo con radio %.2f es: %.2f%n", radio, area);
                    break;
                case 2:
                    System.out.print("Ingresa la longitud del lado: ");
                    double lado = Double.parseDouble(input.nextLine());
                    area = calcularAreaCuadrado(lado);
                    System.out.printf("El área del cuadrado con lado %.2f es: %.2f%n", lado, area);
                    break;
                case 3:
                    System.out.print("Ingresa la base: ");
                    double base = Double.parseDouble(input.nextLine());
                    System.out.print("Ingresa la altura: ");
                    double altura = Double.parseDouble(input.nextLine());
                    area = calcularAreaTriangulo(base, altura);
                    System.out.printf("El área del triángulo con base %.2f y altura %.2f es: %.2f%n", base, altura, area);
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción incorrecta. Inténtalo de nuevo.");
                    break;
            }
        } while (opcion != 4);
        
        input.close();
    }

    public static double calcularAreaCirculo(double radio) {
        return Math.PI * Math.pow(radio, 2);
    }

    public static double calcularAreaCuadrado(double lado) {
        return Math.pow(lado, 2);
    }

    public static double calcularAreaTriangulo(double base, double altura) {
        return (base * altura) / 2;
    }
}
