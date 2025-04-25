import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.code.Exercise5;

public class TestExercise5 {

    static Exercise5 exercise5;

    @BeforeAll
    static void setup(){
        exercise5 = new Exercise5();
    }

    @Test 
    void testFilterLinesWithError(){
        List<String> expectedErrors = Arrays.asList("ERROR - Conexión fallida", "ERROR - Usuario no autorizado", "ERROR - Conexión fallida");
        List<String> actualErrors = exercise5.filterLinesWithError();
        assertIterableEquals(expectedErrors, actualErrors);
    }


}
