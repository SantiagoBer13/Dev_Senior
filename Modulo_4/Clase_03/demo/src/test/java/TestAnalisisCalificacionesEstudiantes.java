import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.code.AnalisisCalificacionesEstudiantes;
import com.code.AnalisisCalificacionesEstudiantes.Student;

public class TestAnalisisCalificacionesEstudiantes {

    private List<String> students;
    private AnalisisCalificacionesEstudiantes analisis;

    @BeforeEach
    public void setup() {
        students = Arrays.asList(
            "Juan,Matemáticas,85",
            "Ana,Historia,90",
            "Pedro,Matemáticas,70",
            "Juan,Historia,75",
            "Ana,Matemáticas,95",
            "Pedro,Historia,80"
        );
        analisis = new AnalisisCalificacionesEstudiantes(students);
    }

    @Test
    public void testCalculateAverageGradesByStudent() {
        Map<String, Double> averages = analisis.calculateAverageGradesByStudent();
        assertEquals(80.0, averages.get("Juan"), 0.01);
        assertEquals(92.5, averages.get("Ana"), 0.01);
        assertEquals(75.0, averages.get("Pedro"), 0.01);
    }

    @Test
    public void testCountStudentsByCourse() {
        Map<String, Integer> counts = analisis.countStudentsByCourse();
        assertEquals(3, counts.get("Matemáticas"));
        assertEquals(3, counts.get("Historia"));
    }

    @Test
    public void testFilterGradesHigher() {
        List<Student> filtered = analisis.filterGradesHigher(80.0);
        assertEquals(3, filtered.size());
    }

    @Test
    public void testGetGradeHigher() {
        Student highest = analisis.getGradeHigher();
        assertNotNull(highest);
        assertEquals("Ana", highest.getName());
        assertEquals(95.0, highest.getGrade());
    }
}
