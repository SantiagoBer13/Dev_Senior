import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.code.exercise2.RepositoryWords;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Map;

/*
 * Tests Unitarios de ejercicio 2.
*/

public class RepositoryWordsTest {
    
    private RepositoryWords repository;
    
    @BeforeEach
    public void setUp() {
        repository = new RepositoryWords();
    }
    
    @Test
    public void testEmptyText() {
        Map<String, Integer> result = repository.countFrecuecyOfWords("");
        assertTrue(result.isEmpty(), "Empty text should return empty map");
    }
    
    @Test
    public void testSingleWord() {
        Map<String, Integer> result = repository.countFrecuecyOfWords("hello");
        assertEquals(1, result.size(), "Map should contain exactly one word");
        assertEquals(1, result.get("hello"), "Frequency of word should be 1");
    }
    
    @Test
    public void testMultipleUniqueWords() {
        Map<String, Integer> result = repository.countFrecuecyOfWords("hello world java test");
        assertEquals(4, result.size(), "Map should contain exactly four words");
        assertEquals(1, result.get("hello"), "Frequency of 'hello' should be 1");
        assertEquals(1, result.get("world"), "Frequency of 'world' should be 1");
        assertEquals(1, result.get("java"), "Frequency of 'java' should be 1");
        assertEquals(1, result.get("test"), "Frequency of 'test' should be 1");
    }
    
    @Test
    public void testRepeatedWords() {
        Map<String, Integer> result = repository.countFrecuecyOfWords("java java java test test");
        assertEquals(2, result.size(), "Map should contain exactly two words");
        assertEquals(3, result.get("java"), "Frequency of 'java' should be 3");
        assertEquals(2, result.get("test"), "Frequency of 'test' should be 2");
    }
    
    @Test
    public void testCaseInsensitivity() {
        Map<String, Integer> result = repository.countFrecuecyOfWords("Java JAVA java");
        assertEquals(1, result.size(), "Map should contain exactly one word");
        assertEquals(3, result.get("java"), "Frequency of 'java' should be 3 (case insensitive)");
    }
    
    @Test
    public void testMixedCaseAndRepeatedWords() {
        Map<String, Integer> result = repository.countFrecuecyOfWords("Hello HELLO world World WORLD");
        assertEquals(2, result.size(), "Map should contain exactly two words");
        assertEquals(2, result.get("hello"), "Frequency of 'hello' should be 3");
        assertEquals(3, result.get("world"), "Frequency of 'world' should be 3");
    }
}
