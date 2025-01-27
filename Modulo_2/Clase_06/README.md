# Ejercicio: Implementar el Patrón de Diseño Observer

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
