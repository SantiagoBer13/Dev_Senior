package Exercise_2;

public class Client {
    public static void main(String[] args) {
        // Crear personas
        Person person1 = new Person("Jorge", "Normal");
        Person person2 = new Person("Ana", "VIP");
        Person person3 = new Person("Carlos", "Normal");

        // Crear estrategias
        DiscountStrategy seasonDiscount = new SeasonDiscountStrategy();
        DiscountStrategy volumeDiscount = new VolumeDiscountStrategy();
        DiscountStrategy vipDiscount = new VipDiscountStrategy();

        // Crear el contexto
        PriceCalculator priceCalculator = new PriceCalculator(seasonDiscount);

        // Aplicar descuento de temporada
        System.out.println("\n--- Descuento de Temporada ---");
        priceCalculator.calculatePrice(100.0, 5, person1);
        priceCalculator.calculatePrice(50.0, 10, person3);

        // Cambiar a estrategia de descuento por volumen
        System.out.println("\n--- Descuento por Volumen ---");
        priceCalculator.setDiscountStrategy(volumeDiscount);
        priceCalculator.calculatePrice(100.0, 12, person1);
        priceCalculator.calculatePrice(150.0, 8, person3);

        // Cambiar a estrategia de descuento VIP
        System.out.println("\n--- Descuento VIP ---");
        priceCalculator.setDiscountStrategy(vipDiscount);
        priceCalculator.calculatePrice(100.0, 4, person2);
        priceCalculator.calculatePrice(200.0, 3, person1);

        // Intento adicional con VIP y volumen juntos
        System.out.println("\n--- Descuento VIP con muchas unidades ---");
        priceCalculator.calculatePrice(100.0, 20, person2);
    }
}
