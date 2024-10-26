public class Exercise1 {
    public static void main(String[] args) throws Exception {
        int operaMathe = 6 / 2 * (1 + 2);
        System.out.print(operaMathe);
        /*
        ¿Cuál es el resultado correcto de la operación? ¿1 o 9?
        Respuesta: Si seguimos el orden de operaciones, primero resolvemos el paréntesis: 1+2=3. Esto deja la expresión como 6/2(3). Como la multiplicación y la división tienen la misma prioridad, se hace de izquierda a derecha. Entonces, nos queda 6/2=3, y luego 3×3=9. O sea, el resultado es 9.

        ¿Por qué algunas calculadoras dan otro resultado?
        Segun referencias que busque en internet se debe a 2 razones principales:
        1) La expresión es ambigua. Como vimos en clase, si no se especifica el orden de los pasos en un algoritmo, es fácil que uno se enrede o saque un resultado inesperado. Para evitar esta confusión, sería mejor escribirla con más paréntesis.
        2) Algunas calculadoras leen el 6/2(3) como si fuera 6/(2×3), haciendo primero 2×3 y después dividiendo. Eso da 1. Lo que pasa es que esas calculadoras ven el 2(3) como si fuera un solo bloque, y eso cambia el orden.
        */
    }
}
