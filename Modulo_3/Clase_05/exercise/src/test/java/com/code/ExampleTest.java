package com.code;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ExampleTest {
    private Example example;

    @BeforeEach
    public void setUp() {
        // Given
        example = new Example();
    }

    @DisplayName("Sumar dos números correctamente")
    @Test
    public void testSumar() {
        // Given
        int a = 2;
        int b = 3;

        // When
        int result = example.sumar(a, b);

        // Then
        assertEquals(5, result);
        assertTrue(result == 5);
        assertInstanceOf(Integer.class, result);
    }

    @DisplayName("Sumar dos números")
    @ParameterizedTest
    @CsvSource({"2, 3, 5", "-1, -1, -2", "0, 5, 5"})
    public void testSumar(int a, int b, int expected) {
        int result = example.sumar(a, b);
        assertEquals(expected, result);
    }

    @DisplayName("Verificar si un número es positivo")
    @Test
    public void testCheckPositivo() {
        // Given
        int positivo = 1;
        int negativo = -1;

        // When - Then
        assertTrue(example.checkPositivo(positivo));
        assertThrows(IllegalArgumentException.class, () -> example.checkPositivo(negativo));
    }

    @DisplayName("Contar letras 'a' en una frase")
    @Test
    void testContarLetrasA() {
        // Given
        String phrase = "abracadabra";

        // When
        int result = example.contarLetrasA(phrase);

        // Then
        assertEquals(5, result);
    }

    @DisplayName("Verificar si una lista contiene un elemento")
    @Test
    void testContieneElemento() {
        // Given
        List<String> list = List.of("a", "b", "c");
        String elemento = "a";

        // When
        boolean result = example.contieneElemento(list, elemento);

        // Then
        assertTrue(result);
    }

    @DisplayName("Revertir una cadena correctamente")
    @Test
    void testRevertirCadena() {
        // Given
        String phrase = "abracadabra";

        // When
        String result = example.revertirCadena(phrase);

        // Then
        assertEquals("arbadacarba", result);
    }

    @DisplayName("Calcular el factorial de un número")
    @Test
    void testFactorial() {
        // Given
        int number = 5;

        // When
        long result = example.factorial(number);

        // Then
        assertEquals(120, result);
    }

    @DisplayName("Manejo de excepción al calcular factorial de número negativo")
    @Test
    void testFactorialNegativo() {
        // Given
        int number = -5;

        // Then - When
        assertThrows(IllegalArgumentException.class, () -> example.factorial(number));
    }

    @DisplayName("Verificar si un número es primo")
    @Test
    void testEsPrimo() {
        // Given
        int number = 7;

        // When
        boolean result = example.esPrimo(number);

        // Then
        assertTrue(result);
    }

    @DisplayName("Verificar si un número menor a 1 no es primo")
    @Test
    void testEsPrimoMenor1() {
        // Given
        int number = 0;

        // When
        boolean result = example.esPrimo(number);

        // Then
        assertFalse(result);
    }

    @DisplayName("Verificar si un número compuesto no es primo")
    @Test
    void testEsPrimoFalse() {
        // Given
        int number = 10;

        // When
        boolean result = example.esPrimo(number);

        // Then
        assertFalse(result);
    }

    @DisplayName("Esperar un mensaje después de un retraso")
    @Test
    void testMensajeConRetraso() throws InterruptedException {
        // When
        String result = example.mensajeConRetraso();

        // Then
        assertEquals("Listo después de retraso", result);
    }

    @DisplayName("Convertir lista de enteros a lista de cadenas")
    @Test
    void testConvertirAString() {
        // Given
        List<Integer> list = List.of(1, 2, 3);

        // When
        List<String> result = example.convertirAString(list);

        // Then
        assertEquals(List.of("1", "2", "3"), result);
    }

    @DisplayName("Calcular la media de una lista de números")
    @Test
    void testCalcularMedia() {
        // Given
        List<Integer> list = List.of(1, 2, 3);

        // When
        double result = example.calcularMedia(list);

        // Then
        assertEquals(2, result);
    }

    @DisplayName("Manejo de excepción al calcular media de una lista vacía")
    @Test
    void testCalcularMediaListaVacia() {
        // Given
        List<Integer> list = List.of();

        // Then - When
        assertThrows(IllegalArgumentException.class, () -> example.calcularMedia(list));
    }

    @DisplayName("Convertir lista de cadenas a una sola cadena con formato")
    @Test
    void testConvertirListaAString() {
        // Given
        List<String> list = List.of("a", "b", "c");

        // When
        String result = example.convertirListaAString(list);

        // Then
        assertEquals("A,B,C", result);
    }
}
