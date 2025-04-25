import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.code.Exercise2;

public class TestExercise2 {

    static Exercise2 exercise2;
    static List<Integer> numeros;

    @BeforeAll
    static void setup(){
        numeros = Arrays.asList(1, 2, 3, 4, 5, 6);
        exercise2 = new Exercise2(numeros);
    }

    @Test
    void testFindEvenNumbers(){
        List<Integer> numbersEven = exercise2.findEvenNumbers();
        assertIterableEquals(Arrays.asList(2,4,6), numbersEven);
    }

    @Test
    void testSumNumbersEven(){
        Integer sum = exercise2.sumEvenNumbers();
        assertEquals(12, sum);
    }

}
