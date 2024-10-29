import java.util.Scanner;

public class Exercise10 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a month (1-12): ");
        byte mes = input.nextByte();

        if (mes > 0 && mes < 13) {
            String daysNumber = switch (mes) {
                case 1, 3, 5, 7, 8, 10, 12 -> "31";
                case 4, 6, 9, 11 -> "30";
                case 2 -> "28";
                default -> "Invalid month";
            };
            System.out.printf("The month %d has %s days%n", mes, daysNumber);
        } else {
            System.out.println("Month not valid.");
        }
        
        input.close();
    }
}
