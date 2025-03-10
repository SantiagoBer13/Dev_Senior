import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.code.exercise1.Task;
import com.code.exercise1.TaskRepository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

/*
 * Pruebas Unitarias para el ejercicio 1.
 * 
 */

public class TaskRepositoryTest {
    private TaskRepository repository;
    
    @BeforeEach
    void setUp() {
        repository = new TaskRepository();
    }
    
    @Test
    void testAddTask() {
        Task task = new Task("Asistir Clase de Java");
        repository.addTask(task);
        
        List<Task> allTasks = repository.getAllTasks();
        assertEquals(1, allTasks.size());
        assertEquals("Asistir Clase de Java", allTasks.get(0).getName());
    }
    
    @Test
    void testFindById() {
        Task task1 = new Task("Asistir Clase de Java");
        Task task2 = new Task("Asistir Clase de Ingles");
        String id2 = task2.getId();
        
        repository.addTask(task1);
        repository.addTask(task2);
        
        Task found = repository.findById(id2);
        assertEquals(task2.getName(), found.getName());
        assertEquals(id2, found.getId());
    }
    
    @Test
    void testRemoveTasksCompleted() {
        Task task1 = new Task("Asistir Clase de Java");
        task1.setCompleted(true);
        
        Task task2 = new Task("Asistir Clase de Ingles");
        
        repository.addTask(task1);
        repository.addTask(task2);
        
        repository.removeTasksCompleted();
        
        List<Task> remaining = repository.getAllTasks();
        assertEquals(1, remaining.size());
        assertEquals("Asistir Clase de Ingles", remaining.get(0).getName());
    }
    
    @Test
    void testGetTaskNoCompleted() {
        Task task1 = new Task("Asistir Clase de Java");
        task1.setCompleted(true);
        
        Task task2 = new Task("Asistir Clase de Ingles");
        Task task3 = new Task("Asistir Tutoria");
        
        repository.addTask(task1);
        repository.addTask(task2);
        repository.addTask(task3);
        
        List<Task> notCompleted = repository.getTasksNoCompleted();
        assertEquals(2, notCompleted.size());
        assertEquals("Asistir Clase de Ingles", notCompleted.get(0).getName());
        assertEquals("Asistir Tutoria", notCompleted.get(1).getName());
        assertFalse(notCompleted.get(0).isCompleted());
        assertFalse(notCompleted.get(1).isCompleted());
    }
}
