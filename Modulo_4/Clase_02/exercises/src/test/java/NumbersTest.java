import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.code.exercise4.Numbers;

public class NumbersTest {
private Numbers numbers;

    @BeforeEach
    public void setUp() {
        numbers = new Numbers();
    }

    @Test
    public void testFindNumbersUniquesWithDuplicates() {
        // Lista con números duplicados
        List<Integer> input = Arrays.asList(1, 2, 3, 2, 4, 1, 5, 6, 3);
        
        Set<Integer> expectedResult = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        Set<Integer> actualResult = numbers.findNumbersUniques(input);
        
        assertEquals(expectedResult, actualResult, "Debe eliminar duplicados correctamente");
        assertEquals(6, actualResult.size(), "Debe contener 6 elementos únicos");
    }

    @Test
    public void testFindNumbersUniquesWithNoDuplicates() {
        // Lista sin números duplicados
        List<Integer> input = Arrays.asList(10, 20, 30, 40, 50);
        
        Set<Integer> expectedResult = new HashSet<>(Arrays.asList(10, 20, 30, 40, 50));
        Set<Integer> actualResult = numbers.findNumbersUniques(input);
        
        assertEquals(expectedResult, actualResult, "No debe modificar lista sin duplicados");
        assertEquals(5, actualResult.size(), "Debe mantener los 5 elementos originales");
    }

    @Test
    public void testFindNumbersUniquesWithEmptyList() {
        // Lista vacía
        List<Integer> input = Collections.emptyList();
        
        Set<Integer> expectedResult = new HashSet<>();
        Set<Integer> actualResult = numbers.findNumbersUniques(input);
        
        assertEquals(expectedResult, actualResult, "Debe devolver conjunto vacío para lista vacía");
        assertTrue(actualResult.isEmpty(), "El conjunto resultado debe estar vacío");
    }

    @Test
    public void testFindNumbersUniquesWithSingleElement() {
        // Lista con un solo elemento
        List<Integer> input = Collections.singletonList(100);
        
        Set<Integer> expectedResult = new HashSet<>(Collections.singletonList(100));
        Set<Integer> actualResult = numbers.findNumbersUniques(input);
        
        assertEquals(expectedResult, actualResult, "Debe mantener el único elemento");
        assertEquals(1, actualResult.size(), "Debe contener 1 elemento");
    }

    @Test
    public void testFindNumbersUniquesWithAllDuplicates() {
        // Lista con todos los elementos duplicados
        List<Integer> input = Arrays.asList(7, 7, 7, 7, 7);
        
        Set<Integer> expectedResult = new HashSet<>(Collections.singletonList(7));
        Set<Integer> actualResult = numbers.findNumbersUniques(input);
        
        assertEquals(expectedResult, actualResult, "Debe eliminar todos los duplicados");
        assertEquals(1, actualResult.size(), "Debe contener solo 1 elemento único");
    }

    @Test
    public void testFindNumbersUniquesWithNegativeNumbers() {
        // Lista con números negativos y duplicados
        List<Integer> input = Arrays.asList(-1, -2, -3, -1, -4, -2);
        
        Set<Integer> expectedResult = new HashSet<>(Arrays.asList(-1, -2, -3, -4));
        Set<Integer> actualResult = numbers.findNumbersUniques(input);
        
        assertEquals(expectedResult, actualResult, "Debe manejar correctamente números negativos");
        assertEquals(4, actualResult.size(), "Debe contener 4 elementos únicos");
    }

}
