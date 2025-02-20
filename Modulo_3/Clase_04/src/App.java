import java.util.ArrayList;
import java.util.List;

class Tarea {
    private String nombre;
    private String descripcion;
    private boolean completada;

    public Tarea(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.completada = false;
    }

    public void marcarComoCompletada() {
        completada = true;
    }

    public boolean estaCompletada() {
        return completada;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "[ " + (completada ? "X" : " ") + " ] " + nombre + ": " + descripcion;
    }
}

class GestorTareas {
    private List<Tarea> tareas = new ArrayList<>();

    public void agregarTarea(String nombre, String descripcion) {
        Tarea nueva = new Tarea(nombre, descripcion);
        tareas.add(nueva);
    }

    public void marcarTareaComoCompletada(int indice) {
        tareas.get(indice).marcarComoCompletada();
    }

    public void listarTareasPendientes() {
        System.out.println("\nTareas pendientes:");
        for (Tarea tarea : tareas) {
            
                System.out.println(tarea);
        }
    }
}

public class App {
    public static void main(String[] args) {
        GestorTareas gestor = new GestorTareas();

        gestor.agregarTarea("Comprar leche", "Ir al supermercado y comprar leche.");
        gestor.agregarTarea("Estudiar Java", "Repasar patrones de diseño y debugging.");
        gestor.agregarTarea("Comprar pan", "Ir al supermercado y comprar pan.");

        // ERROR 1: Intento de marcar una tarea como completada con índice incorrecto

        //gestor.marcarTareaComoCompletada(3); // ¿Qué sucede aquí?

        // Los indices en un array empiezan desde 0, la posición 0 es la primera
        // posición del array, asi que si le pasamos un 3, estamos intentando obtener la tarea 4. Como solución podemos restarle 1 a la posicion que requiere el usuario.

        gestor.marcarTareaComoCompletada(3-1 ); 

        // ERROR 2: No se están listando las tareas correctamente
        gestor.listarTareasPendientes();

        // Al intentar listar todos los pedidos habia una condición que evita que se muestren todas las tareas 'if (!tarea.estaCompletada())'.
    }
}
