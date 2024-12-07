import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/*
 * Generador y Verificador de UIDs para Empleados
 * 
 * Instrucciones para Ingresar UIDs:
 * - Cada UID debe ser una cadena de exactamente 10 caracteres alfanuméricos (sin espacios ni caracteres especiales).
 * - Requisitos para que un UID sea válido:
 *     1. Debe contener al menos 2 letras mayúsculas.
 *     2. Debe contener al menos 3 dígitos numéricos.
 *     3. Debe estar compuesto únicamente de caracteres alfanuméricos (letras y números).
 *     4. No debe contener caracteres repetidos.
 * - Ejemplo de un UID válido: "A1B2C3D4E5".
 * - Escribe "stop" para detener el ingreso de UIDs y proceder con la validación.
 */

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

        if(uids.size() > 0){
            uids.stream().forEach(uid -> {
                System.out.println(uid + (verificarUID(uid) ? " - Válido" : " - Inválido"));
            });
        }else{
            System.out.println("No ingresaste números de identificación único UID.");
        }
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
