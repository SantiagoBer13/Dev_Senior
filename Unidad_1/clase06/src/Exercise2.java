import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Exercise2 {
    static List<String[]> students = new ArrayList<>();
    static Map<String, Integer> countStudentByMateria = new HashMap<>();
    static Scanner sc = new Scanner(System.in);
    Function<String, Integer> toInt = Integer::parseInt;
    static Function<String, Double> toDouble = Double::parseDouble;

    public static void main(String[] args) {
        System.out.println("\nAnálisis de Calificaciones de Estudiantes\n");
        addStudents();

        String menu = """

                Menú
                1) Calcular el Promedio de Calificaciones por Estudiante.
                2) Contar Estudiantes por Materia.
                3) Filtrar Calificaciones Mayores a un Valor Específico.
                4) Obtener la Materia con el Promedio Más Alto.
                5) Ingresar más estudiantes.
                6) Salir.
                """;

        while (true) {
            System.out.print(menu);
            String option = sc.nextLine();
            switch (option) {
                case "1" -> promCalificationByStudent();
                case "2" -> contarStudentsByMateria();
                case "3" -> filtrarCalificacionesMayores();
                case "4" -> materiaPromMasAlto();
                case "5" -> addStudents();
                case "6" -> {
                    System.out.println("Saliendo...");
                    sc.close();
                    return;
                }
                default -> System.out.println("Opción inválida. Intenta de nuevo.");
            }
        }
    }

    private static void addStudents() {
        System.out.println("Ingresa el registro 'estudiante,materia,calificacion'. Escribe 'stop' para terminar:");
        while (true) {
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("stop"))
                break;

            String[] row = input.split(",");
            if (row.length == 3) {
                students.add(row);
            } else {
                System.out.println("Registro inválido. Debe tener el formato 'estudiante,materia,calificacion'.");
            }
        }
    }

    public static void promCalificationByStudent() {
        Map<String, Double> promNotasStudent = students.stream()
                .collect(Collectors.groupingBy(
                        student -> student[0],
                        Collectors.averagingDouble(
                                student -> Double.parseDouble(student[2]))));

        System.out.println("\nPromedio de Calificaciones por Estudiante:\n");

        promNotasStudent
                .forEach((student, avg) -> System.out.printf("Estudiante: %s | Promedio: %.2f%n", student, avg));
    }

    public static void contarStudentsByMateria() {
        countStudentByMateria = students.stream()
                .collect(Collectors.toMap(
                        materia -> materia[1],
                        materia -> 1,
                        Integer::sum));

        System.out.println("\nEstudiantes por Materia:\n");
        for (Map.Entry<String, Integer> entry : countStudentByMateria.entrySet()) {
            System.out.println("Nombre: " + entry.getKey() + " | Cantidad de Estudiantes: " + entry.getValue());
        }
    }

    public static void filtrarCalificacionesMayores() {
        while (true) {
            System.out.print("Ingresa la calificación: ");
            Double nota = toDouble.apply(sc.nextLine());
            if (nota > 0) {
                System.out.printf("%nCalificaciones Mayores a %f:%n",nota);
                students.stream()
                        .filter(row -> toDouble.apply(row[2]) > nota)
                        .forEach(row -> {
                            System.out.printf("Nombre Estudiante: %s | Nombre Materia: %s | Nota: %s.%n", row[0],
                                    row[1], row[2]);
                        });
                break;
            } else {
                System.out.println("Ingresa una calificación positiva.");
            }
        }
    }

    public static void materiaPromMasAlto() {
        Map<String, Double> promNotasMateria = students.stream()
                .collect(Collectors.groupingBy(
                        materia -> materia[1],
                        Collectors.averagingDouble(
                                materia -> Double.parseDouble(materia[2]))));
        Map.Entry<String, Double> materiaConProMax = promNotasMateria.entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .get();

        System.out.printf("%nMateria con el promedio más alto:%n%s | Promedio: %.2f%n",
                materiaConProMax.getKey(), materiaConProMax.getValue());

        // promNotasMateria
        //         .forEach((student, avg) -> System.out.printf("Materia: %s | Promedio: %.2f%n", student, avg));
    }
}