import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.code.Libro;

public class TestLibro {

    static List<Libro> libros;
    static Libro l1, l2, l3, l4, l5;
    
    @BeforeAll
    static void setup(){
        l1 = new Libro("Cien años de soledad", "Gabriel García Márquez", 471);
        l2 = new Libro("1984", "George Orwell", 328);
        l3 = new Libro("El Principito", "Antoine de Saint-Exupéry", 96);
        l4 = new Libro("Don Quijote", "Miguel de Cervantes", 863);
        l5 = new Libro("La sombra del viento", "Carlos Ruiz Zafón", 576);

        libros = Arrays.asList(l1, l2, l3, l4, l5);
    }

    // Exercise 5

    @Test
    void testOrderByAuthot() {
        Collections.sort(libros);
        assertIterableEquals(Arrays.asList(l3, l5, l1, l2, l4), libros);
    }

    @Test
    void testOrderByPages() {
        libros.sort(new ComparatorByPages());
        assertIterableEquals(Arrays.asList(l3, l2, l1, l5, l4), libros);
    }

    @Test
    void testOrderByTitle() {
        libros.sort(new ComparatorByTitle());
        assertIterableEquals(Arrays.asList(l2, l1, l4, l3, l5), libros);
    }

    public class ComparatorByPages implements Comparator<Libro>{

        @Override
        public int compare(Libro o1, Libro o2) {
            return o1.getPages().compareTo(o2.getPages());
        }

    }

    public class ComparatorByTitle implements Comparator<Libro>{

        @Override
        public int compare(Libro o1, Libro o2) {
            return o1.getTitle().compareTo(o2.getTitle());
        }

    }

}
