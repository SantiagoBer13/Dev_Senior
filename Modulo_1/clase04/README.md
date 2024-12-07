# Ejercicios

## [Ejercicio 1 - Conversión de Temperaturas](src/Exercise1.java)
### Definir el Problema:
Necesitamos convertir temperaturas de Celsius a Fahrenheit y viceversa.  
Operaciones para las conversiones:
- **Celsius a Fahrenheit**: La fórmula es `F = (C * 9 / 5) + 32`.
- **Fahrenheit a Celsius**: La fórmula es `C = (F - 32) / 9 * 5`.
### Estructura del Programa:
Crear métodos separados para cada conversión.
### Interacción con el Usuario:
Pedir al usuario que ingrese la temperatura y el tipo de conversión que desea realizar.
### Mostrar Resultados:
Mostrar el resultado de la conversión.  
Por ejemplo:
```
temperatura en Celsius: 25

La temperatura en Fahrenheit es: 77.0
```
```
Ingresa la temperatura en Fahrenheit: 77

La temperatura en Celsius es: 25.0
```


## [Ejercicio 2 - Verificación de Palíndromos](src/Exercise2.java)
### Definir el Problema:
Un palíndromo es una palabra, frase o secuencia de caracteres que se lee igual de izquierda a derecha que de derecha a izquierda, ignorando espacios, puntuación y mayúsculas.  
Ejemplos: 
- radar
- anilina
- A man, a plan, a canal, Panama
### Estructura del Programa:
Crear un método separado que realice la verificación de si una cadena es un palíndromo.
### Interacción con el Usuario:
Pedir al usuario que ingrese una cadena de texto.
### Mostrar Resultados:
Después de verificar si la cadena es un palíndromo, mostrar el resultado al usuario en la consola.  
Por ejemplo:
```
Ingresa una cadena de texto: A man, a plan, a canal, Panama

La cadena es un palíndromo.
```
```
Ingresa una cadena de texto: Hola

La cadena no es un palíndromo.
```

## [Ejercicio 3 - Cálculo de Factorial](src/Exercise3.java)
### Definir el Problema:
El factorial de un número entero positivo `n` (denotado como `n!`) es el producto de todos los enteros positivos desde 1 hasta `n`.  
Por ejemplo:  
```
3! = 3 * 2 * 1 = 6
5! = 5 * 4 * 3 * 2 * 1 = 120
```
### Estructura del Programa:
Crear un método separado que realice el cálculo del factorial.
### Interacción con el Usuario:
Pedir al usuario que ingrese un número entero positivo.
### Mostrar Resultados:
Después de calcular el factorial, mostrar el resultado al usuario en la consola.

## [Ejercicio 4 - Números Primos](src/Exercise4.java)
### Definir el Problema:
Un número primo es un número entero mayor que 1 que solo es divisible por 1 y por sí mismo.  
Ejemplos de números primos: 2, 3, 5, 7, 11, 13, etc.
### Estructura del Programa:
Crear un método separado que realice la verificación de si un número es primo.
### Interacción con el Usuario:
Pedir al usuario que ingrese un número entero positivo.
### Mostrar Resultados:
Después de verificar si el número es primo, mostrar el resultado al usuario en la consola.  
Por ejemplo:
```
Ingresa un número: 29

El número 29 es primo.
```
```
Ingresa un número: 30

El número 30 no es primo.
```

## [Ejercicio 5 - Cálculo de Promedio de tres números](src/Exercise5.java)
### Definir el Problema:
El promedio de tres números se calcula sumando los tres números y dividiendo el resultado entre 3.
### Estructura del Programa:
Crear un método separado que realice el cálculo del promedio.
### Interacción con el Usuario:
Pedir al usuario que ingrese tres números.
### Mostrar Resultados:
Después de calcular el promedio, mostrar el resultado al usuario en la consola.  
Por ejemplo:
```
Ingresa el primer número: 10
Ingresa el segundo número: 20
Ingresa el tercer número: 30

El promedio de los tres números es: 20.0
```
```
Ingresa el primer número: 5
Ingresa el segundo número: 15
Ingresa el tercer número: 25

El promedio de los tres números es: 15.0
```

## [Ejercicio 6 - Conversión de Unidades](src/Exercise6.java)
### Definir el Problema:
Necesitamos convertir unidades de longitud (metros a kilómetros y viceversa) y unidades de masa (gramos a kilogramos y viceversa).
### Estructura del Programa:
Crear métodos separados para cada tipo de conversión (metros a kilómetros, kilómetros a metros, gramos a kilogramos, kilogramos a gramos).
### Interacción con el Usuario:
Pedir al usuario que ingrese el valor y el tipo de conversión que desea realizar.
### Mostrar Resultados:
Después de realizar la conversión, mostrar el resultado al usuario en la consola.

## [Ejercicio 7 - Cálculo de Potencias](src/Exercise7.java)
### Definir el Problema:
Necesitamos calcular la potencia de un número dado una base y un exponente. La fórmula general es `resultado = base ^ exponente`.  
Esto significa que hay que multiplicar la `base` por si mismo `exponente` veces.  
Por ejemplo:
- `2 ^ 4` = `2 * 2 * 2 * 2` = `16`
- `5 ^ 2` = `5 * 5` = `25`
- `27 ^ 1` = `27`
- `325 ^ 0` = `1`

Recuerda que si el exponente es `0`, la potencia es igual a `1`.
### Estructura del Programa:
Crear un método separado que realice el cálculo de la potencia.
### Interacción con el Usuario:
Pedir al usuario que ingrese la base y el exponente.
### Mostrar Resultados:
Después de calcular la potencia, mostrar el resultado al usuario en la consola.

## [Ejercicio 8 - Cálculo de Áreas](src/Exercise8.java)
### Definir el Problema:
Necesitamos calcular el área de un círculo, un cuadrado y un triángulo utilizando las fórmulas matemáticas correspondientes.  
Fórmulas de Cálculo:
- **Área de un Círculo**: La fórmula es `A = pi * r ^ 2`, donde `r` es el radio del círculo.
- **Área de un Cuadrado**: La fórmula es `A = l ^ 2`, donde `l` es la longitud del lado del cuadrado.
- **Área de un Triángulo**: La fórmula es `A = (b * h) / 2`, donde `b` es la base y `h` es la altura del triángulo.
### Estructura del Programa:
Crear métodos separados para calcular el área de cada figura geométrica.  
Puede utilizar la función creada en el **ejercicio 7** para calcular los cuadrados en las formulas.
### Interacción con el Usuario:
Pedir al usuario que ingrese los valores necesarios (radio, lado, base y altura) para calcular el área de cada figura.
### Mostrar Resultados:
Después de calcular el área, mostrar el resultado al usuario en la consola.

## [Ejercicio 9 - Cálculo de Intereses (simple y compuesto)](src/Exercise9.java)
### Definir el Problema:
- **Interés Simple**: El interés se calcula solo sobre el capital inicial durante todo el período.
- **Interés Compuesto**: El interés se calcula sobre el capital inicial más los intereses acumulados en cada período.
#### Fórmulas de Cálculo:
- **Interés Simple**: La fórmula es `I = P * r * t`, donde:
    - `I` es el interés.
    - `P` es el capital inicial.
    - `r` es la tasa de interés anual.
    - `t` es el tiempo en años.
- **Interés Compuesto**: La fórmula es `A = P * (1 + (r / n) ^ (n * t))`, donde:
    - `A` es el monto total después del tiempo `t`.
    - `P` es el capital inicial.
    - `r` es la tasa de interés anual.
    - `n` es el número de veces que se aplica el interés compuesto por año.
    - `t` es el tiempo en años.
### Estructura del Programa:
Crear métodos separados para calcular el interés simple y el interés compuesto.  
Puede utilizar la función creada en el **ejercicio 7** para calcular los cuadrados en las formulas.
### Interacción con el Usuario:
Pedir al usuario que ingrese el capital inicial, la tasa de interés, el tiempo y, en el caso del interés compuesto, el número de veces que se aplica el interés por año.
### Mostrar Resultados:
Después de calcular los intereses, mostrar los resultados al usuario en la consola.  
Por ejemplo:
- Interés Simple
  ```
  Ingresa el monto de capital: 1000
  Ingresa la tasa de interés anual (en porcentaje): 5
  Ingresa el tiempo (en años): 3
  
  El interés simple es: 150.0
  ```
- Interés compuesto
  ```
  Ingresa el monto de capital: 1000
  Ingresa la tasa de interés anual (en porcentaje): 5
  Ingresa el tiempo (en años): 3
  Ingresa el número de veces que se aplica el interés por año: 4
  
  El monto total después de 3 años es: 1157.6250000000002
  El interés compuesto es: 157.62500000000023
  ```


## [Ejercicio 10 - Generación de Tablas de Multiplicar](src/Exercise10.java)
### Definir el Problema:
Necesitamos generar la tabla de multiplicar de un número dado por el usuario, mostrando los resultados desde 1 hasta 10.
### Estructura del Programa:
Crear un método separado que genere y muestre la tabla de multiplicar.  
Usa `printf` para formatear la salida del programa.
### Interacción con el Usuario:
Pedir al usuario que ingrese el número para el cual desea generar la tabla de multiplicar.
### Mostrar Resultados:
Después de generar la tabla de multiplicar, mostrar los resultados al usuario en la consola.  
Por ejemplo::
```
Ingrese el número para generar la tabla: 15

15 x 1 = 15
15 x 2 = 30
...
15 x 10 = 150
```
Generación de Tablas de Multiplicar: Crea un método que genere la tabla de multiplicar de un número dado.

## [Ejercicio 11 - Cálculo de Índice de Masa Corporal](src/Exercise11.java)
### Definir el Problema:
El Índice de Masa Corporal (IMC) es una medida que se utiliza para determinar si una persona tiene un peso saludable en relación con su altura.  
La fórmula para calcular el IMC es: `IMC = peso_kg / (altura_m ^ 2)`.
#### Categorías del IMC:
- **Bajo peso**: IMC < 18.5
- **Peso normal**: IMC entre 18.5 y 24.9
- **Sobrepeso**: IMC entre 25 y 29.9
- **Obesidad**:
    - **Grado I**: IMC entre 30 y 34.9
    - **Grado II**: IMC entre 35 y 39.9
    - **Grado III**: IMC ≥ 401
### Estructura del Programa:
- Crear un método separado que realice el cálculo del IMC.
- Crear un método separado que determine la categoría del IMC basado en el valor calculado.
### Interacción con el Usuario:
Pedir al usuario que ingrese su peso en kilogramos y su altura en metros.
### Mostrar Resultados:
Después de calcular el IMC y determinar la categoría, mostrar los resultados al usuario en la consola.  
Por ejemplo:
```
Ingresa tu peso en kilogramos: 70
Ingresa tu altura en metros: 1.75

Tu IMC es: 22.86
Categoría: Peso normal
```
```
Ingresa tu peso en kilogramos: 85
Ingresa tu altura en metros: 1.60

Tu IMC es: 33.20
Categoría: Obesidad grado I
```

## [Ejercicio 12 - Conversión de segundos](src/Exercise12.java)
### Definir el Problema:
Necesitamos convertir una cantidad de segundos ingresada por el usuario en días, horas, minutos y segundos.
### Estructura del Programa:
Crear un método separado que realice la conversión de segundos a días, horas, minutos y segundos.
### Interacción con el Usuario:
Pedir al usuario que ingrese la cantidad de segundos.
### Mostrar Resultados:
Después de realizar la conversión, mostrar los resultados al usuario en la consola.  
Por ejemplo:
```
Ingresa la cantidad de segundos: 100000

Días: 1
Horas: 3
Minutos: 46
Segundos: 40
```
