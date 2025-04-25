import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.code.Exercise3;

public class TestExercise3 {
    
    static Exercise3 exercise3;
    static String texto;

    @BeforeAll
    static void setup(){
        texto = "Java Streams son geniales. Los Streams en Java hacen la vida más fácil.";
        exercise3 = new Exercise3(texto);
    }

    @Test
    void testFindWordsUniques(){
        List<String> wordsUniques = exercise3.findWordsUniques();
        assertIterableEquals(Arrays.asList("Java","Streams","son","geniales","Los","en","hacen","la","vida","más","fácil"), wordsUniques);
    }

    @Test
    void testCountWordsUniques(){
        Long count = exercise3.countWordsUniques();
        assertEquals(11, count);
    }

}
