import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.code.Exercise6;

public class TestExercise6 {
    static Exercise6 exercise6;

    @BeforeAll
    static void setup() {
        exercise6 = new Exercise6();
    }

    @Test
    void testFindNumbersPrimos() {
        List<Integer> primes = exercise6.findNumbersPrimos();

        assertTrue(primes.stream().allMatch(num -> num == 2 || num % 2 != 0), 
                   "La lista contiene números pares que no deberían estar.");
    }
}
