public class Exercise6 {
    public static void main(String[] args) {
        // Definir el precio de los pantalones después de aplicar el descuento
        float priceAfterDiscount = 34f;
        // Definir el porcentaje que queda después de aplicar el 15% de descuento
        int percentageAfterDiscount = 85;
        // Aplicar regla de tres para encontrar el precio inicial antes del descuento
        float initialPrice = (priceAfterDiscount * 100) / percentageAfterDiscount;
        // Imprimir el precio inicial
        System.out.printf("Initial price is: %.2f", initialPrice);
    }
}
