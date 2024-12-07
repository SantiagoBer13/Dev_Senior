# Ejercicios

## [Tres en línea (tic-tac-toe)](src/Triqui.java)

![Tres en línea](https://upload.wikimedia.org/wikipedia/commons/thumb/3/32/Tic_tac_toe.svg/783px-Tic_tac_toe.svg.png)  
_Tomado de [Tres en línea](https://es.wikipedia.org/wiki/Tres_en_l%C3%ADnea) en wikipedia_.

El tres en línea, también conocido como ceros y cruces, tres en raya (España, México, Ecuador y Bolivia), cerito cruz (en Cuba), michi (en Perú), triqui (en Colombia), cuadritos, juego del gato, gato (en Chile, Costa Rica y México), ta te tí (en Argentina, Paraguay y Uruguay), totito (en Guatemala), triqui traka, equis cero (en Honduras), o la vieja (en Venezuela) es un juego de lápiz y papel entre dos jugadores: **O** y **X**, que marcan los espacios de un tablero de 3×3 alternadamente.

### Reglas
Cada jugador solo debe colocar su símbolo una vez por turno y no debe ser sobre una casilla ya jugada. En caso de que el jugador haga trampa el ganador será el otro. Se debe conseguir realizar una línea recta o diagonal por símbolo.

### Descripción del Problema
El objetivo es desarrollar un programa en Java que permita a dos jugadores jugar al Tic Tac Toe en la consola. El juego debe cumplir con los siguientes requisitos:
1. **Tablero de Juego**: El tablero debe ser una matriz de 3x3 que puede contener los caracteres 'X', 'O' o un espacio vacío para indicar una celda vacía.
1. **Inicialización del Tablero**: Al iniciar el juego, el tablero debe estar vacío.
1. **Mostrar el Tablero**: El programa debe ser capaz de imprimir el tablero en la consola en cualquier momento, mostrando claramente las posiciones ocupadas por 'X' y 'O', así como las celdas vacías.
1. **Realizar Movimientos**: Los jugadores deben poder ingresar sus movimientos especificando la fila y la columna donde desean colocar su marca ('X' o 'O'). El programa debe verificar que el movimiento sea válido (es decir, que la celda esté vacía) antes de actualizar el tablero.
1. **Alternar Turnos**: El programa debe alternar entre los dos jugadores después de cada movimiento válido.
1. **Comprobar Ganador**: Después de cada movimiento, el programa debe verificar si el jugador actual ha ganado. Un jugador gana si tiene tres de sus marcas en una fila, columna o diagonal.
1. **Detectar Empate**: El programa debe detectar si el tablero está lleno y no hay un ganador, declarando un empate.
1. **Finalizar el Juego**: El juego debe terminar cuando haya un ganador o un empate, y debe mostrar un mensaje apropiado indicando el resultado.
1. **Interacción con el Usuario**: El programa debe solicitar a los jugadores que ingresen sus movimientos y proporcionar retroalimentación sobre el estado del juego después de cada movimiento.

## [Ahorcado](src/Ahorcado.java)

![Ahorcado](https://upload.wikimedia.org/wikipedia/commons/thumb/6/6e/Hangman.svg/330px-Hangman.svg.png)  
_Tomado de [Ahorcado (juego)](https://es.wikipedia.org/wiki/Ahorcado_(juego)) en wikipedia_.

El ahorcado (también llamado colgado) es un juego de lápiz y papel para dos o más jugadores. Un jugador piensa en una palabra, frase u oración y el otro trata de adivinarla según lo que sugiere por letras o dentro de un cierto número de oportunidades.

### Reglas
Usando una fila de guiones, se representa la palabra a adivinar, dando el número de letras. Si el jugador adivinador sugiere una letra que aparece en la palabra, el otro jugador la escribe en todas sus posiciones correctas. Si la letra sugerida no ocurre en la palabra, el otro jugador saca un elemento de la figura de hombre palo ahorcado como una marca de conteo. 
 
El juego termina cuando:
1. El jugador adivinador completa la palabra, o adivina la palabra completa correctamente.
1. El otro jugador completa el dibujo del ahorcado.

Se dibuja la horca antes de jugar y dibujan las partes del cuerpo del hombre (tradicionalmente la cabeza, luego el torso, luego los brazos y las piernas de uno en uno).

### Descripción del Problema:

El objetivo es desarrollar un programa en Java que permita a un jugador jugar al Ahorcado en la consola. El juego debe cumplir con los siguientes requisitos:

1. **Palabra Secreta**: El programa debe seleccionar una palabra secreta que el jugador debe adivinar. Esta palabra puede ser elegida aleatoriamente de una lista predefinida de palabras.
1. **Mostrar Progreso**: El programa debe mostrar el progreso del jugador, es decir, las letras adivinadas correctamente y las posiciones de las letras aún no adivinadas representadas por guiones bajos (_).
1. **Adivinar Letras**: El jugador debe poder adivinar letras una por una. El programa debe verificar si la letra adivinada está en la palabra secreta y actualizar el progreso del jugador en consecuencia.
1. **Contar Intentos Fallidos**: El programa debe llevar un conteo de los intentos fallidos del jugador. Cada vez que el jugador adivina una letra incorrecta, se debe incrementar el conteo de intentos fallidos.
1. **Dibujar el Ahorcado**: El programa debe dibujar una figura de un ahorcado en la consola, añadiendo una parte del cuerpo por cada intento fallido. La figura completa del ahorcado debe constar de varias partes (por ejemplo, cabeza, cuerpo, brazos, y piernas).
1. **Detectar Fin del Juego**: El juego debe terminar cuando el jugador adivine todas las letras de la palabra secreta o cuando el número de intentos fallidos alcance un límite predefinido (por ejemplo, 6 intentos fallidos).
1. **Interacción con el Usuario**: El programa debe solicitar al jugador que ingrese sus adivinanzas y proporcionar retroalimentación sobre el estado del juego después de cada adivinanza.
1. **Mensajes de Fin del Juego**: Al finalizar el juego, el programa debe mostrar un mensaje indicando si el jugador ha ganado o perdido, y revelar la palabra secreta si el jugador no la adivinó.

### Ejemplo de tablero cuando pierde
```
Palabra a adivinar: A H _ _ _ A _ O
Letras intentadas: Z J L H A E I O S
   +------+
   |      |
   |      O
   |     \|/
   |      |
   |     / \
   |
+--+--+
|     |
```

### Evolución del dibujo
```
   +------+     +------+     +------+     +------+     +------+     +------+     +------+  
   |      |     |      |     |      |     |      |     |      |     |      |     |      |  
   |            |      O     |      O     |      O     |      O     |      O     |      O  
   |            |            |      |     |     \|     |     \|/    |     \|/    |     \|/ 
   |            |            |      |     |      |     |      |     |      |     |      |  
   |            |            |            |            |            |     /      |     / \ 
   |            |            |            |            |            |            |         
+--+--+      +--+--+      +--+--+      +--+--+      +--+--+      +--+--+      +--+--+      
|     |      |     |      |     |      |     |      |     |      |     |      |     |      

 Inicial      1 Fallo      2 Fallos     3 Fallos     4 Fallos     5 Fallos     6 Fallos / Perdida

```

## [Conecta 4](src/Conecta_4.java)

![Conecta 4](https://th.bing.com/th/id/OIP.-dva42mI9sPCMuL32up1JgAAAA?rs=1&pid=ImgDetMain)  
_Tomado de [Conecta 4](https://es.wikipedia.org/wiki/Conecta_4) en wikipedia_.

Conecta 4 (también conocido como 4 en Línea en algunas versiones) es un juego de mesa para dos jugadores distribuido por Hasbro, en el que se introducen fichas en un tablero vertical con el objetivo de alinear cuatro consecutivas de un mismo color.

### Reglas
El objetivo de Conecta 4 es alinear cuatro fichas sobre un tablero formado por seis filas y siete columnas. Cada jugador dispone de 21 fichas de un color (por lo general, rojas o amarillas).​ Por turnos, los jugadores deben introducir una ficha en la columna que prefieran (siempre que no esté completa) y ésta caerá a la posición más baja. Gana la partida el primero que consiga alinear cuatro fichas consecutivas de un mismo color en horizontal, vertical o diagonal.​ Si todas las columnas están llenas pero nadie ha hecho una fila válida, hay empate.​

Gana el primer jugador que logre alinear 4 fichas de manera horizontal, vertical o diagonal será el ganador.

### Descripción del Problema:
El objetivo es desarrollar un programa en Java que permita a dos jugadores jugar a Conecta 4 en la consola. El juego debe cumplir con los siguientes requisitos:
1. **Tablero de Juego**: El tablero debe ser una matriz de 6 filas por 7 columnas que puede contener los caracteres 'X', 'O' o un espacio vacío para indicar una celda vacía.
1. **Inicialización del Tablero**: Al iniciar el juego, el tablero debe estar vacío.
1. **Mostrar el Tablero**: El programa debe ser capaz de imprimir el tablero en la consola en cualquier momento, mostrando claramente las posiciones ocupadas por 'X' y 'O', así como las celdas vacías.
1. **Realizar Movimientos**: Los jugadores deben poder ingresar sus movimientos especificando la columna donde desean colocar su ficha ('X' o 'O'). El programa debe verificar que el movimiento sea válido (es decir, que la columna no esté llena) antes de actualizar el tablero.
1. **Alternar Turnos**: El programa debe alternar entre los dos jugadores después de cada movimiento válido.
1. **Comprobar Ganador**: Después de cada movimiento, el programa debe verificar si el jugador actual ha ganado. Un jugador gana si tiene cuatro de sus fichas en una fila, columna o diagonal.
1. **Detectar Empate**: El programa debe detectar si el tablero está lleno y no hay un ganador, declarando un empate.
1. **Finalizar el Juego**: El juego debe terminar cuando haya un ganador o un empate, y debe mostrar un mensaje apropiado indicando el resultado.
1. **Interacción con el Usuario**: El programa debe solicitar a los jugadores que ingresen sus movimientos y proporcionar retroalimentación sobre el estado del juego después de cada movimiento.