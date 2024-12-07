import java.util.Scanner;

public class Exercise11 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int num1 = input.nextInt();
        
        System.out.print("Enter second number: ");
        int num2 = input.nextInt();
        
        System.out.print("Enter third number: ");
        int num3 = input.nextInt();
        
        if(num1 == num2 && num1 == num3){
            System.out.printf("The numbers are equal: %d %d %d%n", num1, num2, num3);
        }else{
            if (num1 > num2) {
                int temp = num1;
                num1 = num2;
                num2 = temp;
            }
            if (num1 > num3) {
                int temp = num1;
                num1 = num3;
                num3 = temp;
            }
            if (num2 > num3) {
                int temp = num2;
                num2 = num3;
                num3 = temp;
            }
        }

        System.out.printf("%d%d%d",num1, num2, num3);

        input.close();
    }
}
