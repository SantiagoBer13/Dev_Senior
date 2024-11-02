import java.util.Scanner;

public class Exercise4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Números Primos");
        int numero;
        do{
            System.out.print("Ingresa un número: ");
            numero = input.nextInt();
        }while(numero < 1);
        boolean esPrimo = verificarPrimo(numero);
        if(esPrimo){
            System.out.printf("El número %d es primo.", numero);
        }else{
            System.out.printf("El número %d no es primo.", numero);
        }
        input.close();
    }

    public static boolean verificarPrimo(int numero){
        boolean esPrimo = true;
        if (numero == 1) {
            esPrimo = false;
        }

        for(int i = 2; i < numero; i++){
            if(numero % i == 0){
                esPrimo = false;
            }
        }

        return esPrimo;
    }
}
