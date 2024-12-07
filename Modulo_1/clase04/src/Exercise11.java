import java.util.Scanner;

public class Exercise11 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double kg, altura;
        
        System.out.println("Cálculo de Índice de Masa Corporal");
        
        do {
            System.out.print("Ingresa tu peso en kilogramos (>0): ");
            kg = input.nextDouble();
        } while (kg <= 0);

        do {
            System.out.print("Ingresa tu altura en metros (>0): ");
            altura = input.nextDouble();
        } while (altura <= 0);

        double imc = calcularIMC(kg, altura);
        System.out.printf("Tu IMC es: %.2f%n", imc);
        
        String categoriaIMC = calcularCategoriaIMC(imc);
        System.out.printf("Categoría: %s%n", categoriaIMC);
        
        input.close();
    }

    public static double calcularIMC(double kg, double altura){
        return kg / Math.pow(altura, 2);
    }

    public static String calcularCategoriaIMC(double imc) {
        if (imc > 0 && imc < 18.5) {
            return "Bajo peso";
        } else if (imc >= 18.5 && imc < 25) {
            return "Peso normal";
        } else if (imc >= 25 && imc < 30) {
            return "Sobrepeso";
        } else if (imc >= 30 && imc < 35) {
            return "Obesidad: Grado I";
        } else if (imc >= 35 && imc < 40) {
            return "Obesidad: Grado II";
        } else if (imc >= 40) {
            return "Obesidad: Grado III";
        } else {
            return "IMC Incorrecto";
        }
    }
}
