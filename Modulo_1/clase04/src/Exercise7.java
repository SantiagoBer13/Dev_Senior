import java.lang.Math;
import java.util.Scanner;

public class Exercise7 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Cálculo de Potencias");
        
        System.out.print("Ingresa la base: ");
        int base = input.nextInt();
        System.out.print("Ingresa la potencia: ");
        int potencia = input.nextInt();
        
        calcularPotencia(base, potencia);
        input.close();
    }

    public static void calcularPotencia(int base, int potencia){
        double nPotencia = Math.pow(base, potencia);
        String cadena = "";
        for(int i = 0; i < potencia; i++){
            cadena += String.format("%d ",base);
            if(i < (potencia - 1)){
                cadena += "* ";
            }
        }

        if(potencia == 0 || potencia == 1){
            System.out.printf("%d ^ %d = %.0f", base, potencia,nPotencia);
        }else{
            System.out.printf("%d ^ %d = %s= %.0f", base, potencia, cadena,nPotencia);
        }
    }
}