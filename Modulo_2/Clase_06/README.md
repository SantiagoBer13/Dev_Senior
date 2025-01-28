# [Ejercicio: Implementar el Patrón de Diseño Observer](src/Exercise_1/App.java)

## Contexto

Imagina que estás desarrollando un sistema de monitoreo de precios para una tienda en línea. Este sistema debe notificar automáticamente a los usuarios registrados cuando el precio de un producto cambia.

## Requisitos

1. **Producto (Subject):**
   - Representa un producto en la tienda.
   - Puede tener un precio que cambia con el tiempo.
   - Mantiene una lista de observadores (usuarios) que desean ser notificados sobre cambios en el precio.
   - Debe permitir registrar y eliminar observadores dinámicamente.
   - Notifica a todos los observadores cada vez que el precio cambie.

2. **Usuario (Observer):**
   - Representa a un cliente que está interesado en el precio de un producto.
   - Cuando el precio cambia, el usuario debe recibir una notificación con el nuevo precio.

3. **Funcionamiento:**
   - Implementa una clase `Product` que actúe como el `Subject`.
   - Crea una interfaz `Observer` para definir el comportamiento de los usuarios al recibir notificaciones.
   - Implementa una clase concreta `Customer` que represente a un usuario registrado en el sistema.
   - Crea un programa principal donde:
     - Se registra a varios clientes como observadores de un producto.
     - Se simula un cambio en el precio del producto.
     - Los clientes reciben y procesan las notificaciones de la actualización del precio.

## Consideraciones

- Diseña el sistema para que permita agregar nuevos productos u observadores sin modificar el código existente.
- Utiliza nombres descriptivos para las clases, métodos y atributos.
- Asegúrate de que el programa principal muestre claramente las notificaciones que cada usuario recibe.

## Ejemplo de Salida Esperada

```text
Cliente 1: El precio del producto 'Laptop' cambió a $1200.
Cliente 2: El precio del producto 'Laptop' cambió a $1200.
Cliente 1: El precio del producto 'Laptop' cambió a $1150.
Cliente 3: El precio del producto 'Laptop' cambió a $1150.
```

# [Enunciado de práctica para el patrón de diseño Strategy](src/Exercise_2/Client.java)

Implementa un sistema para calcular precios de productos en una tienda online. La tienda ofrece diferentes estrategias de descuento según la temporada o las promociones actuales:

1. **Descuento de temporada**: Aplica un 20% de descuento a todos los productos.
2. **Promoción por compra en volumen**: Aplica un 15% de descuento si el cliente compra más de 10 unidades de un producto.
3. **Descuento para clientes VIP**: Aplica un 25% de descuento para clientes registrados como VIP.

## Requisitos:

1. Crea una **interfaz común** llamada `DiscountStrategy` que defina un método `applyDiscount(double price, int quantity)`.
2. Implementa **tres estrategias concretas** para cada tipo de descuento:
   - `SeasonalDiscountStrategy`
   - `VolumeDiscountStrategy`
   - `VipDiscountStrategy`
3. Desarrolla una clase **Context** llamada `PriceCalculator` que permita aplicar la estrategia de descuento seleccionada.
4. Diseña un **componente cliente** que permita:
   - Seleccionar dinámicamente la estrategia de descuento.
   - Calcular el precio final de un producto aplicando la estrategia seleccionada.

## Ejemplo de uso:

```java
// Crear las estrategias
DiscountStrategy seasonalDiscount = new SeasonalDiscountStrategy();
DiscountStrategy volumeDiscount = new VolumeDiscountStrategy();
DiscountStrategy vipDiscount = new VipDiscountStrategy();

// Crear el contexto y establecer una estrategia
PriceCalculator priceCalculator = new PriceCalculator(seasonalDiscount);

// Calcular el precio con descuento de temporada
double finalPrice = priceCalculator.calculatePrice(100.0, 5); // Precio inicial: $100, Cantidad: 5
System.out.println("Precio con descuento de temporada: $" + finalPrice);

// Cambiar a estrategia de descuento por volumen
priceCalculator.setDiscountStrategy(volumeDiscount);
finalPrice = priceCalculator.calculatePrice(100.0, 12); // Precio inicial: $100, Cantidad: 12
System.out.println("Precio con descuento por volumen: $" + finalPrice);

// Cambiar a estrategia de descuento para clientes VIP
priceCalculator.setDiscountStrategy(vipDiscount);
finalPrice = priceCalculator.calculatePrice(100.0, 1); // Precio inicial: $100, Cantidad: 1
System.out.println("Precio para cliente VIP: $" + finalPrice);
