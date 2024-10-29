import java.util.Scanner;
import java.util.Random;

public class Exercise18 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        double sumPositives = 0;
        double sumNegatives = 0;
        int countPositives = 0;
        int countNegatives = 0;
        int countZeros = 0;

        for (int count = 0; count < 120; count++) {
            int number = random.nextInt(-100, 101);
            
            if (number > 0) {
                sumPositives += number;
                countPositives++;
            } else if (number < 0) {
                sumNegatives += number;
                countNegatives++;
            } else {
                countZeros++;
            }
        }

        double promPositives = (countPositives > 0) ?  sumPositives / countPositives : 0;
        double promNegatives = (countNegatives > 0) ?  sumNegatives / countNegatives : 0;

        System.out.printf("Sum of positive numbers: %.2f%n", sumPositives);
        System.out.printf("Sum of negative numbers: %.2f%n", sumNegatives);
        System.out.printf("Average of positive numbers: %.2f%n", promPositives);
        System.out.printf("Average of negative numbers: %.2f%n", promNegatives);
        System.out.printf("Count of zeros: %d%n", countZeros);

        input.close();
    }
}
