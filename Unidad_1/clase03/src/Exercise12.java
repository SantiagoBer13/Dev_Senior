import java.util.Scanner;

public class Exercise12{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the weight of the watermelon in kilgrams: ");
        int weight = input.nextInt();

        if(weight > 2 && weight % 2 == 0){
            System.out.print("YES");
        }else{
            System.out.print("NO");
        }

        input.close();
    }
}