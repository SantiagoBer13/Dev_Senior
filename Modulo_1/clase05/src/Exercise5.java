import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Exercise5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Queue<String> cola = new ArrayDeque<>();
        int option;
        String menu = """
                1) Agregar documento a la cola.
                2) Imprimir documento.
                3) Mostrar documentos en la cola.
                0) Salir.
                """;
        do {
            System.out.println("Gestión de una cola de impresión.");
            System.out.print(menu);
            System.out.print("Ingresa una opción: ");
            option = Integer.parseInt(input.nextLine());

            switch (option) {
                case 1:
                    addDoc(cola, input);
                    break;
                case 2:
                    printDoc(cola);
                    break;
                case 3:
                    showDocs(cola);
                    break;  
                case 0:
                    System.out.println("Saliendo.");
                    break;  
                default:
                    System.out.println("Opción no válida, por favor intenta de nuevo.");
                    break;
            }
        } while (option != 0);
        input.close();
    }
    
    public static void addDoc(Queue<String> cola, Scanner input){
        System.out.println();
        System.out.print("Ingresa el documento: ");
        String doc = input.nextLine();
        cola.offer(doc);
        System.out.println();
    }

    public static void printDoc(Queue<String> cola){
        System.out.println();
        String printing = cola.poll();
        if(printing != null){
            System.out.printf("Se imprimio el documento: %s.%n", printing);
        }else{
            System.out.println("No hay documentos para imprimir.");
        }
        System.out.println();
    }

    public static void showDocs(Queue<String> cola){
        System.out.println();
        if(cola.size() > 0){
            for (String doc : cola) {
                System.out.println(doc);
            }
        }else{
            System.out.println("No hay documentos en la cola.");
        }
        System.out.println();
    }
}
