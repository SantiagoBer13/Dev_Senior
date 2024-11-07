import java.util.LinkedList;
import java.util.Scanner;

public class Exercise7 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LinkedList<String> students = new LinkedList<>();

        int option;
        String menu = """
                Gestión de una lista de estudiantes en un curso
                1) Agregar nuevo estudiante.
                2) Eliminar estudiante.
                3) Mostrar estudiantes.
                0) Salir.
                """;
        do {
            System.out.print(menu);
            System.out.print("Ingresa una opción: ");
            option = Integer.parseInt(input.nextLine());

            switch (option) {
                case 1:
                    addStudent(students, input);
                    break;
                case 2:
                    showStudents(students);
                    deleteStudent(students,input);
                    break;
                case 3:
                    showStudents(students);
                    break;  
                case 0:
                    System.out.println("Saliendo.");
                    break;  
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
                    break;
            }
        } while (option != 0);
        input.close();
    }

    public static void addStudent(LinkedList<String> students, Scanner input){
        System.out.println();
        System.out.print("Ingresa el nombre del estudiante: ");
        String student = input.nextLine();
        students.add(student);
        System.out.printf("Estudiante %s agregado correctamente.%n", student);
        System.out.println();
    }

    public static void deleteStudent(LinkedList<String> students, Scanner sc){
        if(students.size() > 0){
            System.out.println("Ingresa el indice del studiante que deseas eliminar: ");
            int index = Integer.parseInt(sc.nextLine());
            if(index > 0 && index <= students.size()){
                students.remove(index-1);
                System.out.println("Estudiante eliminado.");
            }else{
                System.out.println("Indice no encontrado.");
            } 
        }
        System.out.println();
    }

    public static void showStudents(LinkedList<String> students){
        System.out.println();
        if(students.size() > 0){
            for (int index = 0; index < students.size(); index++) {
                System.out.printf("%d) %s.%n", (index+1), students.get(index));
            }
        }else{
            System.out.println("No hay estudiantes.");
        }
        System.out.println();
    }
}
