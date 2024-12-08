import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        List<Student> students = List.of(
            new Student("Santiago Castillo", 30, 4.5),
            new Student("Santiago Bernal", 22, 4.6),
            new Student("Santiago Lozano", 19, 4.2),
            new Student("Santiago Giraldo", 32, 3.5),
            new Student("Santiago Diaz", 31, 2.5)
        );

        for (Student student : students) {
            student.showDetails();
            if (student.isAprobated()) {
                System.out.println("Está aprobado.");
            } else {
                System.out.println("No está aprobado.");
            }
            System.out.println();
        }
    }
}