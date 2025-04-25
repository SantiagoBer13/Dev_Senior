import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.code.Exercise7;
import com.code.Exercise7.Producto;

public class TestExercise7 {
    
    static Exercise7 exercise7;

    @BeforeAll
    static void setup(){
        List<Producto> productos = Arrays.asList(
            new Producto("Café", 5.0, "Bebidas"),
            new Producto("Té", 3.0, "Bebidas"),
            new Producto("Pan", 2.5, "Alimentos"),
            new Producto("Galletas", 4.0, "Alimentos")
        );
        exercise7 = new Exercise7(productos);
    }

    @Test
    void testGruopingByCategory(){
       Map<String, List<Producto>> grouped = exercise7.gruopingByCategory();

        assertEquals(2, grouped.size());

        List<String> bebidas = grouped.get("Bebidas").stream()
                                      .map(Producto::getName)
                                      .toList();
        assertIterableEquals(Arrays.asList("Café", "Té"), bebidas);

        List<String> alimentos = grouped.get("Alimentos").stream()
                                        .map(Producto::getName)
                                        .toList();
        assertIterableEquals(Arrays.asList("Pan", "Galletas"), alimentos);
    }

}
