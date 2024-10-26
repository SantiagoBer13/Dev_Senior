public class Exercise5 {
    public static void main(String[] args) {
        //Definir precio del PC
        float pcPrice  = 660f;
        //Definir porcentaje de descuento
        int dcto = 10;
        //Precio con el dcto.
        float priceWithDcto = pcPrice - (pcPrice * dcto / 100);
        //Imprimir Resultado
        System.out.printf("Total price of the PC with accessories: %.2f euros.", priceWithDcto);
    }
}
