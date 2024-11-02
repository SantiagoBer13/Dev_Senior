import java.util.Scanner;

public class Exercise10 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numero;

        System.out.println("Generación de Tablas de Multiplicar");
        System.out.printf("Ingrese el número para generar la tabla: ");
        numero = input.nextInt();
        System.out.println();
        mostrarTablaMultiplicar(numero);

        input.close();
    }

    public static void mostrarTablaMultiplicar(int numero) {
        for (int i = 1; i < 11; i++) {
            System.out.printf("%d x %d = %d%n", numero, i, (numero * i));
        }
    }
}
