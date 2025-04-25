import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.code.Empleado;

public class TestEmpleado {

    static List<Empleado> empleados;
    static Empleado e1, e2, e3, e4, e5;

    @BeforeAll
    static void setup(){
        e1 = new Empleado("Carlos", 30, 2500.00);
        e2 = new Empleado("Ana", 25, 3000.00);
        e3 = new Empleado("Beatriz", 40, 2200.00);
        e4 = new Empleado("Daniel", 35, 2800.00);
        e5 = new Empleado("Elena", 28, 2400.00);

        empleados = Arrays.asList(e1, e2, e3, e4, e5);
    }

    // Exercise 5

    @Test
    void testOrderByName() {
        empleados.sort(new ComparatorByName());
        assertIterableEquals(Arrays.asList(e2, e3, e1, e4, e5), empleados);
    }

    @Test
    void testOrderByAge() {
        empleados.sort(new ComparatorByAge());
        assertIterableEquals(Arrays.asList(e2, e5, e1, e4, e3), empleados);
    }

    @Test
    void testOrderBySalario() {
        empleados.sort(new ComparatorBySalario());
        assertIterableEquals(Arrays.asList(e3, e5, e1, e4, e2), empleados);
    }

    public class ComparatorByName implements Comparator<Empleado>{

        @Override
        public int compare(Empleado o1, Empleado o2) {
            return o1.getName().compareTo(o2.getName());
        }

    }

    public class ComparatorByAge implements Comparator<Empleado>{

        @Override
        public int compare(Empleado o1, Empleado o2) {
            return o1.getAge().compareTo(o2.getAge());
        }

    }

    public class ComparatorBySalario implements Comparator<Empleado>{

        @Override
        public int compare(Empleado o1, Empleado o2) {
            return o1.getSalario().compareTo(o2.getSalario());
        }

    }

}
