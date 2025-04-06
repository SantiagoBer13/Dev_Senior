import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.code.exercise3.RepositoryStudent;
import com.code.exercise3.Student;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

/*
 * Tests Unitarios de ejercicio 3.
*/

public class RepositoryStudentTest {

    private RepositoryStudent repository;
    private ByteArrayOutputStream outputStreamCaptor;

    @BeforeEach
    public void setUp() {
        repository = new RepositoryStudent();
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void testAddStudent() throws Exception {
        // Add a student
        repository.addStudent("John Doe", 20, "Active");
        
        // Get the students list using reflection
        List<Student> students = repository.getStudentsList();
        
        // Verify student was added correctly
        assertEquals(1, students.size());
        Student addedStudent = students.get(0);
        assertEquals("John Doe", addedStudent.getName());
        assertEquals(20, addedStudent.getAge());
        assertEquals("Active", addedStudent.getStatus());
    }
    
    @Test
    public void testAddMultipleStudents() throws Exception {
        // Add multiple students
        repository.addStudent("John Doe", 20, "Active");
        repository.addStudent("Jane Smith", 22, "Inactive");
        repository.addStudent("Bob Johnson", 21, "Active");
        
        // Get the students list using reflection
        List<Student> students = repository.getStudentsList();
        
        // Verify students were added correctly
        assertEquals(3, students.size());
    }
    
    @Test
    public void testDeleteStudentsWithStatusInactive() throws Exception {
        // Add students with different statuses
        repository.addStudent("John Doe", 20, "Active");
        repository.addStudent("Jane Smith", 22, "Inactive");
        repository.addStudent("Bob Johnson", 21, "Active");
        repository.addStudent("Alice Brown", 23, "Inactive");
        
        // Delete inactive students
        repository.deleteStudentsWithStatusInactive();
        
        // Get the students list using reflection
        List<Student> students = repository.getStudentsList();
        
        // Verify only active students remain
        assertEquals(2, students.size());
        for (Student student : students) {
            assertEquals("Active", student.getStatus());
        }
    }
    
    @Test
    public void testDeleteStudentsWithStatusInactiveNoInactiveStudents() throws Exception {
        // Add only active students
        repository.addStudent("John Doe", 20, "Active");
        repository.addStudent("Bob Johnson", 21, "Active");
        
        // Delete inactive students (should have no effect)
        repository.deleteStudentsWithStatusInactive();
        
        // Get the students list using reflection
        List<Student> students = repository.getStudentsList();
        
        // Verify all students remain
        assertEquals(2, students.size());
    }
    
    @Test
    public void testShowStudentsEmptyRepository() {
        
        // Get the output
        String output = outputStreamCaptor.toString().trim();
        
        // Verify output is empty
        assertEquals("", output);
    }
}
