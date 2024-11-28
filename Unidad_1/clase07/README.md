![Conecta 4](https://th.bing.com/th/id/OIP.-dva42mI9sPCMuL32up1JgAAAA?rs=1&pid=ImgDetMain)  
_Tomado de [Conecta 4](https://es.wikipedia.org/wiki/Conecta_4) en wikipedia_.

Conecta 4 (también conocido como 4 en Línea en algunas versiones) es un juego de mesa para dos jugadores distribuido por Hasbro, en el que se introducen fichas en un tablero vertical con el objetivo de alinear cuatro consecutivas de un mismo color.

## Reglas
El objetivo de Conecta 4 es alinear cuatro fichas sobre un tablero formado por seis filas y siete columnas. Cada jugador dispone de 21 fichas de un color (por lo general, rojas o amarillas).​ Por turnos, los jugadores deben introducir una ficha en la columna que prefieran (siempre que no esté completa) y ésta caerá a la posición más baja. Gana la partida el primero que consiga alinear cuatro fichas consecutivas de un mismo color en horizontal, vertical o diagonal.​ Si todas las columnas están llenas pero nadie ha hecho una fila válida, hay empate.​

Gana el primer jugador que logre alinear 4 fichas de manera horizontal, vertical o diagonal será el ganador.

## Descripción del Problema:
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