# Ejercicios
## [Ejercicio 1: Filtrado y transformación de datos](exercises/src/test/java/TestExercise1.java)
**Nivel**: Básico 

Dada una lista de cadenas, los estudiantes deben filtrar las cadenas que comiencen con la letra "A", convertirlas a mayúsculas y ordenarlas alfabéticamente.

Entrada ejemplo:
```java
List<String> palabras = Arrays.asList("Apple", "Avocado", "Banana", "Apricot", "Blueberry");
```

Salida esperada:
```txt
[APPLE, APRICOT, AVOCADO]
```

## [Ejercicio 2: Suma de números pares](exercises/src/test/java/TestExercise2.java)
**Nivel**: Básico

Dada una lista de números enteros, calcula la suma de todos los números pares utilizando Streams.

**Entrada ejemplo**:
```java
List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6);
```

**Salida esperada**:
```txt
12
```

## [Ejercicio 3: Contar palabras únicas en un texto](exercises/src/test/java/TestExercise3.java)
**Nivel**: Intermedio 

Dado un párrafo de texto, los estudiantes deben usar Streams para contar cuántas palabras únicas tiene.

**Entrada ejemplo**:

```java
String texto = "Java Streams son geniales. Los Streams en Java hacen la vida más fácil.";
```

**Salida esperada**:
```
15 palabras únicas
```

## [Ejercicio 4: Encontrar el producto más caro](exercises/src/test/java/TestExercise4.java)
**Nivel**: Intermedio

Dada una lista de objetos Producto con los atributos nombre, precio, y categoría, encuentra el producto más caro.

**Entrada ejemplo**:
```java
List<Producto> productos = Arrays.asList(
    new Producto("Café", 5.0, "Bebidas"),
    new Producto("Té", 3.0, "Bebidas"),
    new Producto("Pan", 2.5, "Alimentos")
);
```

**Salida esperada**:
```txt
Producto más caro: Café - 5.0
```

## [Ejercicio 5: Procesamiento de logs](exercises/src/test/java/TestExercise5.java)
**Nivel**: Avanzado

Dado un archivo de logs, los estudiantes deben usar Streams para filtrar las líneas que contienen la palabra "ERROR" y contar cuántas veces aparece cada tipo de error.

**Entrada ejemplo (archivo logs.txt)**:
```txt
INFO - Inicio del sistema
ERROR - Conexión fallida
ERROR - Usuario no autorizado
INFO - Operación exitosa
ERROR - Conexión fallida
```

**Salida esperada**:
```txt
Conexión fallida: 2
Usuario no autorizado: 1
```

## [Ejercicio 6: Encontrar números primos (Parallel Streams)](exercises/src/test/java/TestExercise6.java)
**Nivel**: Avanzado

Dado un rango de números, utiliza Parallel Streams para encontrar todos los números primos en el rango dado.

**Entrada ejemplo**:
```java
int inicio = 1;
int fin = 1000;
```

Salida esperada (solo como ejemplo):
```txt
[2, 3, 5, 7, 11, 13, ...]
```

## [Ejercicio 7: Agrupar y calcular promedio](exercises/src/test/java/TestExercise7.java)
**Nivel**: Avanzado

Dada una lista de productos, agrupa los productos por categoría y calcula el precio promedio de cada grupo utilizando Parallel Streams.

**Entrada ejemplo**:
```java
List<Producto> productos = Arrays.asList(
    new Producto("Café", 5.0, "Bebidas"),
    new Producto("Té", 3.0, "Bebidas"),
    new Producto("Pan", 2.5, "Alimentos"),
    new Producto("Galletas", 4.0, "Alimentos")
);
```

**Salida esperada**:
```txt
Bebidas: 4.0
Alimentos: 3.25
```

## Ejercicio 8: Comparar rendimiento entre Streams secuenciales y paralelos
**Nivel**: Desafío

Los estudiantes deben generar una lista grande (por ejemplo, 10 millones de números) y comparar el tiempo de ejecución para sumar todos los elementos usando Streams secuenciales y Parallel Streams.

**Salida esperada**:
```txt 
Tiempo secuencial: X ms
Tiempo paralelo: Y ms
```