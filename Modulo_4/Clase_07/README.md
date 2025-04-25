# Ejercicios
## [Ejercicio 1: Orden natural usando `Comparable`](exercises/src/test/java/TestProducto.java)
Crea una clase `Producto` con los siguientes atributos:
- String nombre
- Double precio

Implementa la interfaz `Comparable` para que los objetos `Producto` se puedan ordenar por el atributo precio (de menor a mayor).
1. Crea una lista de productos con precios variados.
1. Ordena la lista utilizando `Collections.sort()` y muestra los resultados.

```Java
List<Producto> productos = Arrays.asList(
        new Producto("Laptop", 1200.99),
        new Producto("Celular", 799.49),
        new Producto("Teclado", 45.99),
        new Producto("Monitor", 199.99),
        new Producto("Ratón", 25.50));
```

## [Ejercicio 2: Orden personalizado usando `Comparator`](exercises/src/test/java/TestProducto.java)
Utilizando la misma clase `Producto`, implementa la lógica para ordenar de manera personalizada:
1. Ordena los productos alfabéticamente por el atributo nombre.
1. Ordena los productos en orden descendente por el atributo precio.

**Pista**: Usa lambdas o crea clases que implementen Comparator.

## [Ejercicio 3: Múltiples criterios de ordenación](exercises/src/test/java/TestProducto.java)
Amplía la clase `Producto` para incluir el atributo:
- Integer cantidad

Crea un `Comparator` que:
1. Ordene los productos primero por cantidad (de mayor a menor).
1. En caso de empate, ordene los productos por precio (de menor a mayor).

Usa una lista de ejemplo y ordena los objetos utilizando el comparador.

```Java
List<Producto> productos = Arrays.asList(
        new Producto("Laptop", 1200.99, 5),
        new Producto("Celular", 799.49, 10),
        new Producto("Teclado", 45.99, 50),
        new Producto("Monitor", 199.99, 7),
        new Producto("Ratón", 25.50, 50));
```

## [Ejercicio 4: Comparación de fechas](exercises/src/test/java/TestEvento.java)
Crea una clase `Evento` con los siguientes atributos:
- String titulo
- LocalDate fecha

1. Usa `Comparable` para ordenar los eventos en orden cronológico (de la fecha más antigua a la más reciente).
1. Usa Comparator para ordenar alfabéticamente los eventos por el atributo titulo.

Crea una lista de eventos con diferentes fechas y títulos, y ordena según ambos criterios.

```Java
List<Evento> eventos = Arrays.asList(
        new Evento("Conferencia de Tecnología", LocalDate.of(2025, 5, 20)),
        new Evento("Hackathon Global", LocalDate.of(2025, 4, 15)),
        new Evento("Taller de Inteligencia Artificial", LocalDate.of(2025, 6, 10)),
        new Evento("Networking Empresarial", LocalDate.of(2025, 3, 25)),
        new Evento("Exposición de Innovación", LocalDate.of(2025, 7, 5)));
```

### [Ejercicio 5: Ordenación dinámica con el usuario](exercises/src/test/java/TestEmpleado.java)
Crea un programa que permita al usuario elegir dinámicamente el criterio de ordenación para una lista de objetos `Empleado`, con los atributos:
- String nombre
- Integer edad
- Double salario

El programa debe:
1. Mostrar un menú al usuario para seleccionar el criterio de ordenación (por ejemplo: por nombre, edad o salario).
2. Usar un `Comparator` para aplicar el criterio seleccionado y mostrar los resultados.

## [Ejercicio 6: Mezcla de Comparable y Comparator](exercises/src/test/java/TestLibro.java)
Combina el uso de `Comparable` y `Comparator`:

1. Haz que la clase `Libro` implemente `Comparable` para ordenarse por el atributo `autor` (alfabéticamente).
1. Crea un `Comparator` adicional para ordenar los libros por:
  - Número de páginas (`Integer paginas`) de menor a mayor.
  - En caso de empate, por el título (`String titulo`).

Prueba ordenando una lista de libros con diversos datos.

## Ejercicio 7: Uso básico de `ConcurrentHashMap`
Crea un programa que simule un inventario de productos en una tienda. Usa un `ConcurrentHashMap` para almacenar:
- **Clave**: El nombre del producto (String).
- **Valor**: La cantidad disponible (Integer).

**Tareas a realizar**:
1. Añade productos al inventario desde múltiples hilos.
1. Incrementa o reduce la cantidad disponible de ciertos productos de forma concurrente.
1. Muestra el inventario final al terminar las operaciones.

**Reto adicional**: Implementa un método para buscar un producto específico de manera segura mientras los hilos están realizando modificaciones.

## Ejercicio 8: Uso de `CopyOnWriteArrayList`
Simula una sala de chat en la que múltiples usuarios pueden unirse o abandonar de forma concurrente. Usa un `CopyOnWriteArrayList` para almacenar:
- Una lista de nombres de usuarios (String).

**Tareas a realizar**:
1. Añade usuarios desde diferentes hilos.
1. Permite a algunos usuarios abandonar el chat mientras se sigue iterando la lista para mostrar los participantes actuales.
1. Imprime la lista de usuarios activos después de cada operación.

**Reto adicional**: Muestra un mensaje cada vez que alguien se une o abandona el chat.

## Ejercicio 9: Uso de `ConcurrentLinkedQueue`
Simula un sistema de colas en un banco usando `ConcurrentLinkedQueue`. Los clientes llegan y se añaden a la cola para ser atendidos.

**Tareas a realizar**:
1. Añade clientes a la cola desde múltiples hilos (por ejemplo, simula la llegada de clientes).
1. Crea otro hilo que simule a un cajero, retirando clientes de la cola para atenderlos.
1. Muestra los clientes que fueron atendidos y los que aún están en espera.

**Reto adicional**: Implementa un tiempo de espera para atender a los clientes con la clase `Thread.sleep()`.

## Ejercicio 10: Uso de `BlockingQueue` (Productor-Consumidor)
Implementa el clásico problema productor-consumidor usando una `ArrayBlockingQueue` de capacidad fija (por ejemplo, 5 elementos).

**Tareas a realizar**:
1. Simula un productor que agregue elementos a la cola (puedes usar cadenas como "Elemento 1", "Elemento 2", etc.).
1. Simula un consumidor que retire elementos de la cola de forma concurrente.
1. Asegúrate de que el programa no produzca elementos en exceso ni consuma más de lo disponible.

**Reto adicional**: Si la cola está llena, el productor debe esperar. Si la cola está vacía, el consumidor debe esperar.

## Ejercicio 11: Uso de ConcurrentSkipListMap
Crea un programa que gestione una agenda de citas organizadas por fecha y hora. Usa un `ConcurrentSkipListMap` para almacenar:
- **Clave**: La fecha y hora de la cita (LocalDateTime).
- **Valor**: El título de la cita (String).

**Tareas a realizar**:
1. Añade citas a la agenda desde múltiples hilos.
1. Recupera y muestra las citas en orden cronológico.
1. Permite buscar una cita específica por fecha y hora.

**Reto adicional**: Implementa un método para eliminar citas pasadas automáticamente desde otro hilo.

## Ejercicio 12: Simulación compleja con múltiples colecciones
Crea un programa que simule un sistema de procesamiento de pedidos en una tienda en línea. Usa varias colecciones concurrentes:
- Un `ConcurrentHashMap` para almacenar los productos disponibles y sus cantidades.
- Una `BlockingQueue` para manejar pedidos entrantes.
- Un `ConcurrentLinkedQueue` para almacenar los pedidos procesados.

**Tareas a realizar**:
1. Simula varios hilos que añadan pedidos a la cola de pedidos entrantes.
1. Crea otro conjunto de hilos que procesen esos pedidos, actualizando el inventario en el `ConcurrentHashMap`.
1. Mueve los pedidos procesados a la cola de pedidos completados y muestra el resultado final.

**Reto adicional**: Implementa un sistema de registro para imprimir mensajes que indiquen cuándo se añade, procesa o completa un pedido.