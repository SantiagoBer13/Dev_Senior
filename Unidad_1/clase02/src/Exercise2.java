import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise2 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        // Creamos un lector para leer la entrada del usuario desde la consola
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        // Definimos el precio por cada 100 gramos
        float priceOneHundredGrams = 5.95f;
        
        // Solicitamos al usuario ingresar los kilogramos que desea comprar
        System.out.print("Enter kilograms: ");
        // Convertimos la entrada a float
        float kilos = Float.parseFloat(reader.readLine());  
        
        // Convertimos los kilogramos a gramos
        float grams = kilos * 1000;  // 1 kilogramo = 1000 gramos
        
        // Calculamos el precio total en función del precio por 100 gramos
        float price = (grams / 100) * priceOneHundredGrams;
        
        // Mostramos el precio total formateado a dos decimales
        System.out.printf("Precio: %.2f €", price);
    }
}
