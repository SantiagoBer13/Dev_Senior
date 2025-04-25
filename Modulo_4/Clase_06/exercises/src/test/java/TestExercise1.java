import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.code.Exercise1;

public class TestExercise1 {
    
    static List<String> words;
    static Exercise1 exercise1;

    @BeforeAll
    static void setup(){
        words = Arrays.asList("Apple", "Avocado", "Banana", "Apricot", "Blueberry");
        exercise1 = new Exercise1(words);
    }

    @Test
    void testFilterStartWithA(){
        List<String> wordsStartWithA = exercise1.filterStartWithA();
        assertIterableEquals(Arrays.asList("Apple", "Avocado", "Apricot"), wordsStartWithA);
    }

    @Test
    void testConvertToUpperCase(){
        List<String> wordsUpperCase = exercise1.converToUpperCase();
        assertIterableEquals(Arrays.asList("APPLE", "AVOCADO", "APRICOT"), wordsUpperCase);
    }

    @Test
    void testSortedAlphabetic(){
        List<String> wordsSorted = exercise1.sortedAlphabetic();
        assertIterableEquals(Arrays.asList("APPLE", "APRICOT", "AVOCADO"), wordsSorted);
    }
}
