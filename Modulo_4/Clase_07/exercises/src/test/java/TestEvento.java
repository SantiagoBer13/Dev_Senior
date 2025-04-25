import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.code.Evento;

public class TestEvento {
    
    static List<Evento> eventos;

    static Evento evento1 = new Evento("Conferencia de Tecnología", LocalDate.of(2025, 5, 20));
    static Evento evento2 =  new Evento("Hackathon Global", LocalDate.of(2025, 4, 15));
    static Evento evento3 = new Evento("Taller de Inteligencia Artificial", LocalDate.of(2025, 6, 10));
    static Evento evento4 = new Evento("Networking Empresarial", LocalDate.of(2025, 3, 25));
    static Evento evento5 = new Evento("Exposición de Innovación", LocalDate.of(2025, 7, 5));

    @BeforeAll
    static void setup(){
        eventos = Arrays.asList(
        evento1,
        evento2,
        evento3,
        evento4,
        evento5);
    }

    // Exercise 4

    @Test
    void testOrdenCronologic(){
        Collections.sort(eventos);
        assertIterableEquals(Arrays.asList(evento4, evento2, evento1, evento3, evento5), eventos);
    } 

    @Test
    void testOrderAlphabetic(){
        Collections.sort(eventos, new ComparatorByTitle());
        assertIterableEquals(Arrays.asList(evento1, evento5, evento2, evento4, evento3), eventos);
    }

    public class ComparatorByTitle implements Comparator<Evento>{

        @Override
        public int compare(Evento o1, Evento o2) {
            return o1.getTitle().compareTo(o2.getTitle());
        }

    }

}
