import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Cálculo de Factorial");
        int numero;
        do{
            System.out.print("Ingresa un número entero positivo: ");
            numero = input.nextInt();
        }while(numero < 1);
        calcularFactorial(numero);
        
        input.close();
    }

    public static void calcularFactorial(int numero){
        int factorial = 1;
        String cadena = "";
        for(int i = numero; i >= 1; i--){
            factorial *= i;
            cadena += String.format("%d ",i);
            if(i > 1){
                cadena += "* ";
            }
        }
        System.out.printf("%d! = %s= %d", numero, cadena, factorial);
    }
}