import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.code.exercise1.Document;
import com.code.exercise1.RepositoryPrinter;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;
import java.util.LinkedList;

/*
 * Tests Unitarios de ejercicio 1.
*/

public class RepositoryPrinterTest {

    private RepositoryPrinter printer;
    
    // Helper method to reset the static fields between tests
    private void resetSingleton() throws Exception {
        Field instanceField = RepositoryPrinter.class.getDeclaredField("repositoryPrinter");
        instanceField.setAccessible(true);
        instanceField.set(null, null);
        
        Field sheetsField = RepositoryPrinter.class.getDeclaredField("numberSheets");
        sheetsField.setAccessible(true);
        sheetsField.set(null, 30);
        
        Field queueField = RepositoryPrinter.class.getDeclaredField("queueDocuments");
        queueField.setAccessible(true);
        queueField.set(null, new LinkedList<>());
    }
    
    @BeforeEach
    public void setUp() throws Exception {
        resetSingleton();
        printer = RepositoryPrinter.getInstance();
    }
    
    @Test
    public void testGetInstance() {
        RepositoryPrinter instance1 = RepositoryPrinter.getInstance();
        RepositoryPrinter instance2 = RepositoryPrinter.getInstance();
        assertSame(instance1, instance2, "getInstance should return the same instance");
    }
    
    @Test
    public void testAddDocument() {
        Document doc = new Document("Test content", 5);
        printer.addDocument(doc);
        assertEquals(1, printer.getQueueSize(), "Queue size should be 1 after adding a document");
    }
    
    @Test
    public void testAddNullDocument() {
        assertThrows(IllegalArgumentException.class, () -> {
            printer.addDocument(null);
        }, "Should throw IllegalArgumentException when adding null document");
    }
    
    @Test
    public void testPrintDocument() {
        Document doc = new Document("Test content", 5);
        printer.addDocument(doc);
        String result = printer.printDocument();
        assertEquals("Imprimiendo el documento: Test content", result, 
                "Printing message should match expected format");
        assertEquals(0, printer.getQueueSize(), "Queue should be empty after printing");
        assertEquals(25, printer.getAvailableSheets(), "Sheets should be reduced after printing");
    }
    
    @Test
    public void testPrintDocumentEmptyQueue() {
        String result = printer.printDocument();
        assertEquals("No documents in queue", result, 
                "Should return appropriate message when queue is empty");
    }
    
    @Test
    public void testPrintDocumentNotEnoughSheets() {
        Document doc = new Document("Large document", 40);
        printer.addDocument(doc);
        assertThrows(IllegalStateException.class, () -> {
            printer.printDocument();
        }, "Should throw IllegalStateException when not enough sheets");
    }
    
    @Test
    public void testLoadSheets() {
        printer.loadSheets(20);
        assertEquals(50, printer.getAvailableSheets(), "Sheets should be increased after loading");
    }
    
    @Test
    public void testLoadInvalidSheets() {
        assertThrows(IllegalArgumentException.class, () -> {
            printer.loadSheets(0);
        }, "Should throw IllegalArgumentException when loading zero sheets");
    }
    
    @Test
    public void testLoadNegativeSheets() {
        assertThrows(IllegalArgumentException.class, () -> {
            printer.loadSheets(-5);
        }, "Should throw IllegalArgumentException when loading negative sheets");
    }
    
    @Test
    public void testMultiplePrinting() {
        Document doc1 = new Document("Document 1", 10);
        Document doc2 = new Document("Document 2", 15);
        
        printer.addDocument(doc1);
        printer.addDocument(doc2);
        
        assertEquals(2, printer.getQueueSize(), "Queue size should be 2 after adding documents");
        
        String result1 = printer.printDocument();
        assertEquals("Imprimiendo el documento: Document 1", result1, 
                "First print message should match");
        assertEquals(20, printer.getAvailableSheets(), "Should have 20 sheets left after first print");
        
        String result2 = printer.printDocument();
        assertEquals("Imprimiendo el documento: Document 2", result2, 
                "Second print message should match");
        assertEquals(5, printer.getAvailableSheets(), "Should have 5 sheets left after second print");
    }
    
}