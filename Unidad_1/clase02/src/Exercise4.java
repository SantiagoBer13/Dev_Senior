public class Exercise4{
    public static void main(String[] args) {
        // Definir cantidad inicial
        float initialAmount = 23f;
        // Definir cantidad de dinero al llegar a casa
        float finalAmount = 12.75f;
        // Calcular dinero gastado
        float amountSpent = initialAmount - finalAmount;
        // Imprimir resultado
        System.out.printf("Carmen has spent %.2f euros.", amountSpent);
    }
}