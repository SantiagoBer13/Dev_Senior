import java.util.Scanner;

public class Exercise2{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Matriz de Rotación");
        System.out.print("Ingresa el tamaño de la dimensión de la matriz: ");
        int n = Integer.parseInt(input.nextLine());
        int [][] matriz = new int[n][n];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.printf("Ingresa el valor para la posición [%d][%d]: ",i,j);
                matriz[i][j] = Integer.parseInt(input.nextLine());
            }
        }
        System.out.println("Matriz de entrada");
        showMatriz(matriz);
        int[][] matrizRotated = rotate90(matriz);
        System.out.println("Matriz rotada 90 grados.");
        showMatriz(matrizRotated);

        input.close();
    }

    private static void showMatriz(int[][] matriz) {
        for (int[] row : matriz) {
            for (int value : row) {
                System.out.printf("%d ", value);
            }
            System.out.println();
        }
    }

    private static int[][] rotate90(int[][] matriz) {
        int n = matriz.length;
        int[][] matrizRotated = new int[n][n];
        int l = 0;
        for (int i = n - 1; i > -1; i--) {
            for (int j = 0; j < n; j++) {
                matrizRotated[j][l] = matriz[i][j];
            }
            l++;
        }

        return matrizRotated;
    }
}