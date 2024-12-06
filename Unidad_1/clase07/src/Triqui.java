import java.util.Scanner;

public class Triqui {
    static String[][] tablero = new String[3][3];
    static String p1, p2;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        System.out.println("=== BIENVENIDO AL JUEGO DE TRES EN LÍNEA (TRIQUI) ===");
        boolean condition;
        showTable();
        do {
            System.out.println("\nJugador 1: elige tu ficha (X o O).");
            System.out.print("Ingresa tu elección: ");
            String option = sc.nextLine();
            condition = option.equalsIgnoreCase("X") || option.equalsIgnoreCase("O");
            if (!condition) {
                System.out.println("\n[!] Opción no válida. Por favor, elige 'X' o 'O'.");
            } else {
                p1 = option.toUpperCase();
                p2 = p1.equalsIgnoreCase("X") ? "O" : "X";
                System.out.printf("%n[JUGADOR 1] JUEGA CON: %s.%n", p1);
                System.out.printf("[JUGADOR 2] JUEGA CON: %s.%n", p2);
                playTriqui();
            }
        } while (!condition);
        showTable();
    }

    public static void showTable() {
        System.out.println("\n=== ESTADO ACTUAL DEL TABLERO ===");
        System.out.println();
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                System.out.printf(" %s %s", tablero[i][j] == null ? " " : tablero[i][j], j != 2 ? "|" : "");
            }
            System.out.printf("%s", i != 2 ? String.format("%n-----------%n") : String.format("%n%n"));
        }
    }

    public static void playTriqui() {
        int intentos = 0, row, column;
        do {
            System.out.printf("\n[JUEGO] Turno del jugador con ficha '%s'.%n", (intentos % 2 == 0 ? p1 : p2));
            System.out.print("[INPUT] Escoge la fila (1-3): ");
            row = Integer.parseInt(sc.nextLine());
            System.out.print("[INPUT] Escoge la columna (1-3): ");
            column = Integer.parseInt(sc.nextLine());
            if (row > 3 || column > 3 || row < 1 || column < 1) {
                System.out.printf("%n[!] La posición [%d][%d] no existe. Intenta de nuevo.%n", row, column);
                continue;
            }
            if (tablero[row - 1][column - 1] == null) {
                tablero[row - 1][column - 1] = (intentos % 2 == 0 ? p1 : p2);
                intentos += 1;
            } else {
                System.out.println("\n[!] Esta posición ya está ocupada. Elige otra.");
            }
            showTable();
            if (intentos == 9) {
                System.out.println("\n[FINAL] El juego ha terminado. ¡No hay ganador!");
                break;
            }
            if (intentos > 4 && verifyWinner()) {
                System.out.printf("%n[FINAL] ¡Felicidades! El jugador con ficha '%s' ha ganado.%n", (intentos % 2 == 0 ? p2 : p1));
                break;
            }
        } while (true);
    }

    public static boolean verifyWinner() {
        if ((tablero[0][0] == tablero[0][1] && tablero[0][0] == tablero[0][2] && tablero[0][0] != null) ||
            (tablero[1][0] == tablero[1][1] && tablero[1][0] == tablero[1][2] && tablero[1][0] != null) ||
            (tablero[2][0] == tablero[2][1] && tablero[2][0] == tablero[2][2] && tablero[2][0] != null)) {
            return true;
        }
        if ((tablero[0][0] == tablero[1][0] && tablero[0][0] == tablero[2][0] && tablero[0][0] != null) ||
            (tablero[0][1] == tablero[1][1] && tablero[0][1] == tablero[2][1] && tablero[0][1] != null) ||
            (tablero[0][2] == tablero[1][2] && tablero[0][2] == tablero[2][2] && tablero[0][2] != null)) {
            return true;
        }
        if ((tablero[0][0] == tablero[1][1] && tablero[0][0] == tablero[2][2] && tablero[0][0] != null) ||
            (tablero[2][0] == tablero[1][1] && tablero[2][0] == tablero[0][2] && tablero[2][0] != null)) {
            return true;
        }
        return false;
    }
}