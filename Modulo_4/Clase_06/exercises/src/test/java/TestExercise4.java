import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.code.Exercise4;
import com.code.Exercise4.Product;

public class TestExercise4 {

    static List<Product> productos;
    static Exercise4 exercise4;

    @BeforeAll
    static void setup() {
        productos = Arrays.asList(
                new Product("Café", 5.0, "Bebidas"),
                new Product("Té", 3.0, "Bebidas"),
                new Product("Pan", 2.5, "Alimentos"));
        exercise4 = new Exercise4(productos);
    }

    @Test
    void testFindProductMoreCaro(){
        Product productMoreCaro = exercise4.findProductMoreCaro();
        assertEquals("Café", productMoreCaro.getName());
    }

    @Test
    void testFindProductMoreCheap(){
        Product productMoreCheap = exercise4.findProductMoreCheap();
        assertEquals("Pan", productMoreCheap.getName());
    }

}
