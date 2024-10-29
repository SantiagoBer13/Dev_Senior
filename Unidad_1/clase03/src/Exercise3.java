import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number;

        System.out.print("Enter a number: ");
        number = Integer.parseInt(input.nextLine());

        if(number % 2 == 0){
            System.out.printf("%d is even%n", number);
        }else{
            System.out.printf("%d is odd%n", number);
        }

        input.close();
    }
}
