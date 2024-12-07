import java.util.Scanner;

public class Exercise16{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        int number, suma = 0;

        do {
            System.out.print("Enter a negative number: ");
            number = input.nextInt();
            if(number < 0){
                suma += number;
            }else{
                System.out.printf("Exiting. Sum of negative numbers: %d%n", suma);
            }
        } while (number < 0);

        input.close();
    }
}