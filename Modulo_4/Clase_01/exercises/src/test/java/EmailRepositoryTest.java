import org.junit.jupiter.api.Test;

import com.code.exercise2.EmailRepository;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmailRepositoryTest {
    
    @Test
    public void testRemoveEmailsRepeated_WithDuplicates() {
        // Given
        List<String> emailList = Arrays.asList("user1@example.com", "user2@example.com", "user1@example.com", "user3@example.com");
        EmailRepository repository = new EmailRepository(emailList);
        
        // When
        List<String> result = repository.removeEmailsRepeated();
        
        // Then
        assertEquals(3, result.size());
        assertTrue(result.contains("user1@example.com"));
        assertTrue(result.contains("user2@example.com"));
        assertTrue(result.contains("user3@example.com"));
    }
    
    @Test
    public void testRemoveEmailsRepeated_NoDuplicates() {
        // Given
        List<String> emailList = Arrays.asList("user1@example.com", "user2@example.com", "user3@example.com");
        EmailRepository repository = new EmailRepository(emailList);
        
        // When
        List<String> result = repository.removeEmailsRepeated();
        
        // Then
        assertEquals(3, result.size());
        assertTrue(result.contains("user1@example.com"));
        assertTrue(result.contains("user2@example.com"));
        assertTrue(result.contains("user3@example.com"));
    }
    
    @Test
    public void testRemoveEmailsRepeated_EmptyList() {
        // Given
        EmailRepository repository = new EmailRepository(Collections.emptyList());
        
        // When
        List<String> result = repository.removeEmailsRepeated();
        
        // Then
        assertTrue(result.isEmpty());
    }
    
    @Test
    public void testRemoveEmailsRepeated_NullList() {
        // Given
        EmailRepository repository = new EmailRepository(null);
        
        // When
        List<String> result = repository.removeEmailsRepeated();
        
        // Then
        assertTrue(result.isEmpty());
    }
    
    @Test
    public void testRemoveEmailsRepeated_ManyDuplicates() {
        // Given
        List<String> emailList = Arrays.asList(
            "user1@example.com", "user1@example.com", "user1@example.com",
            "user2@example.com", "user2@example.com",
            "user3@example.com"
        );
        EmailRepository repository = new EmailRepository(emailList);
        
        // When
        List<String> result = repository.removeEmailsRepeated();
        
        // Then
        assertEquals(3, result.size());
        assertTrue(result.contains("user1@example.com"));
        assertTrue(result.contains("user2@example.com"));
        assertTrue(result.contains("user3@example.com"));
    }
}