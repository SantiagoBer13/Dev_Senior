import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.code.Exercise1;

public class TestExercise1 {

    static Exercise1 exercise1;
    static List<String> uids;

    @BeforeAll
    static void setup(){
        uids = Arrays.asList(
            "B1CD102354",
            "B1CDEF2354"
        );
        exercise1 = new Exercise1(uids);
    }

    @Test
    void testGenerateUids(){
        List<String> validations = exercise1.generateUids();

        List<String> expected = Arrays.asList(
            "B1CD102354 - Inválido",
            "B1CDEF2354 - Válido"
        );

        assertIterableEquals(expected, validations);
    }

}
