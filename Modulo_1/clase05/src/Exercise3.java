import java.util.ArrayList;
import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> lista = new ArrayList<>();

        int option;
        String menu = """
                1) Agregar nueva tarea.
                2) Eliminar tarea completada.
                3) Mostrar todas las tareas pendientes.
                0) Salir.
                """;
        do {
            System.out.println("Gestión de una lista de tareas pendientes.");
            System.out.print(menu);
            System.out.print("Ingresa una opción: ");
            option = Integer.parseInt(input.nextLine());

            switch (option) {
                case 1:
                    addHomwerk(lista, input);
                    break;
                case 2:
                    showHomeworks(lista);
                    deleteHomework(lista, input);
                    break;
                case 3:
                    showHomeworks(lista);
                    break;  
                case 0:
                    System.out.println("Saliendo.");
                    break;  
                default:
                    break;
            }
        } while (option != 0);
    }    

    public static void addHomwerk(ArrayList<String> lista, Scanner input){
        System.out.println();
        System.out.print("Ingresa la tarea: ");
        String homework = input.nextLine();
        lista.add(homework);
        System.out.println("Tarea agregada: " + homework);
        System.out.println();
    }

    public static void showHomeworks(ArrayList<String> lista){
        System.out.println();
        if(lista.size() > 0){
            for (int index = 0; index < lista.size(); index++) {
                System.out.printf("%d) %s%n", (index + 1), lista.get(index));
            }
        }else{
            System.out.println("No hay tareas pendientes");
        }
        System.out.println();
    }

    public static void deleteHomework(ArrayList<String> lista, Scanner sc){
        System.out.println();
        System.out.print("Ingresa indice de tarea que desea eliminar: ");
        int option = Integer.parseInt(sc.nextLine());
        if(option < 0 || option > (lista.size() - 1)){
            System.out.println("indice no encontrado.");
        } else{
            String homeworkDeleted = lista.get(option);
            lista.remove(option - 1);
            System.out.printf("Tarea completada y eliminada: %s.%n", homeworkDeleted);
        }
        System.out.println();
    }
}
