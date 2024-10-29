import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int firstNumber, secondNumber, thirdNumber;

        System.out.print("Enter the first number: ");
        firstNumber = Integer.parseInt(input.nextLine());
        System.out.print("Enter the second number: ");
        secondNumber = Integer.parseInt(input.nextLine());
        System.out.print("Enter the third number: ");
        thirdNumber = Integer.parseInt(input.nextLine());

        if(firstNumber == secondNumber && secondNumber == thirdNumber){
            System.out.println("All numbers are equal.");
        }else{
            int largestNumber = firstNumber;
        
            if(secondNumber > largestNumber) {
                largestNumber = secondNumber;
            }
            if(thirdNumber > largestNumber) {
                largestNumber = thirdNumber;
            }

            System.out.printf("%d is the largest number.", largestNumber);
        }
        
        input.close();
    }
}
