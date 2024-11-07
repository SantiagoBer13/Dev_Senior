import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Funciones con uso de arrays");
        System.out.print("Ingresa tamaño de array (entero positivo): ");
        int n = Integer.parseInt(input.nextLine());
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            System.out.printf("Ingresa número para la posición %d del array: ", i);
            array[i] = Integer.parseInt(input.nextLine());
        }

        System.out.print("Array ingresado: " );
        printArray(array);

        int sum = sumElementsArray(array);
        System.out.printf("La suma de los elementos es: %d.%n", sum);

        int valueHigher = findValueHigher(array);
        System.out.printf("El valor máximo es: %d.%n", valueHigher);

        int valueLower = findValueLower(array);
        System.out.printf("El valor mínimo es: %d.%n", valueLower);

        int[] invertArray = invertArray(array);
        System.out.print("Array invertido: ");
        printArray(invertArray); 

        double prom = promArray(sum, array.length);
        System.out.printf("El promedio de los elementos del array es: %.2f %n", prom);

        String moda = modaArray(array);
        System.out.printf("La moda del array es: %s%n", moda);

        int[] orderedArray = orderMayorToLower(array);
        System.out.print("Array ordenado de mayor a menor: ");
        printArray(orderedArray); 

        orderedArray = orderLowerToMayor(array);
        System.out.print("Array ordenado de menor a mayor: ");
        printArray(orderedArray);

        input.close();
    }

    public static int sumElementsArray(int[] array) {
        int sum = 0;
        for (int element : array) {
            sum += element;
        }
        return sum;
    }

    public static int findValueHigher(int[] array) {
        int valueHigher = array[0];
        for (int i : array) {
            if (i > valueHigher) {
                valueHigher = i;
            }
        }
        return valueHigher;
    }

    public static int findValueLower(int[] array) {
        int valueLower = array[0];
        for (int i : array) {
            if (i < valueLower) {
                valueLower = i;
            }
        }
        return valueLower;
    }

    public static int[] invertArray(int[] array) {
        int[] arrayInverted = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            arrayInverted[i] = array[array.length - 1 - i];
        }
        return arrayInverted;
    }

    public static int[] orderMayorToLower(int[] array) {
        int[] orderedArray = array.clone();
        int n = orderedArray.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orderedArray[j] < orderedArray[j + 1]) {
                    int temp = orderedArray[j];
                    orderedArray[j] = orderedArray[j + 1];
                    orderedArray[j + 1] = temp;
                }
            }
        }
        return orderedArray;
    }

    public static int[] orderLowerToMayor(int[] array) {
        int[] orderedArray = array.clone();
        int n = orderedArray.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orderedArray[j] > orderedArray[j + 1]) {
                    int temp = orderedArray[j];
                    orderedArray[j] = orderedArray[j + 1];
                    orderedArray[j + 1] = temp;
                }
            }
        }
        return orderedArray;
    }

    public static double promArray(double suma, double size) {
        return suma / size;
    }

    public static String modaArray(int[] array) {
        int moda = array[0];
        int maxCount = 0;
        boolean multipleModas = false;

        for (int i = 0; i < array.length; i++) {
            int count = 0;

            for (int j = 0; j < array.length; j++) {
                if (array[j] == array[i]) {
                    count++;
                }
            }

            if (count > maxCount) {
                maxCount = count;
                moda = array[i];
                multipleModas = false;
            } else if (count == maxCount && array[i] != moda) {
                multipleModas = true;
            }
        }

        return (maxCount == 1 || multipleModas) ? "No tiene moda.": String.valueOf(moda);
    }

    public static void printArray(int[] array) {
        for (int i : array) {
            System.out.printf(" %d", i);
        }
        System.out.println();
    }
}
