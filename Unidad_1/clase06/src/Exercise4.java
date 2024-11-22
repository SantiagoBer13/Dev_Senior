import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Exercise4 {
    static List<String> uids = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("\nGenerador de ID para los empleados (Intermedio)\n");
        addUID();
    }

    private static void addUID() {
        System.out.println("Ingresa los UID, Escribe 'stop' para terminar:");
        while (true) {
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("stop"))
                break;

            uids.add(input);
        }

        uids.stream().forEach(uid -> {
            System.out.println(uid + (verificarUID(uid) ? " - Válido" : " - Inválido"));
        });

    }

    public static boolean verificarUID(String uid) {
        return contarMayusculas(uid) >= 2 &&
               contarDigitos(uid) >= 3 &&
               uid.matches("[A-Za-z0-9]+") &&
               verificarCaracteresRepetidos(uid) &&
               uid.length() == 10;
    }

    public static int contarMayusculas(String uid) {
        int countMayusculas = 0;

        for (int i = 0; i < uid.length(); i++) {

            if (Character.isUpperCase(uid.charAt(i))) {
                countMayusculas++;
            }

        }

        return countMayusculas;
    }

    public static int contarDigitos(String uid) {
        int countDigitos = 0;

        for (int i = 0; i < uid.length(); i++) {
            if (Character.isDigit(uid.charAt(i))) {
                countDigitos++;
            }
        }

        return countDigitos;
    }

    public static boolean verificarCaracteresRepetidos(String uid) {
        Set<Character> setUID = new HashSet<>();
        for (char c : uid.toCharArray()) {
            setUID.add(c);
        }

        return uid.length() == setUID.size();
    }
}
