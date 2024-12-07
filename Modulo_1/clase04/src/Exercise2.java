import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Ingresa una cadena de texto: ");
        String cadena = input.nextLine();
        
        boolean esPalindromo = esPalindromo(cadena);

        if (esPalindromo) {
            System.out.println("La cadena es un palíndromo.");
        } else {
            System.err.println("La cadena no es un palíndromo.");
        }

        input.close();
    }

    private static boolean esPalindromo(String texto) {
        String limpio = texto.replaceAll("[^a-zA-Z]", "").toLowerCase();
        String textoReverse = "";

        for (int i = limpio.length() - 1; i >= 0; i--) {
            textoReverse += limpio.charAt(i);
        }

        return limpio.equals(textoReverse);
    }
}
