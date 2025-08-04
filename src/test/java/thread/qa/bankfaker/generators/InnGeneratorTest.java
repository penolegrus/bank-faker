package thread.qa.bankfaker.generators;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InnGeneratorTest {
    
    private InnGenerator generator;
    
    @BeforeEach
    void setUp() {
        generator = new InnGenerator();
    }
    
    @Test
    void testGenerateValidInn() {
        for (int i = 0; i < 100; i++) {
            String inn = generator.generate();
            assertNotNull(inn);
            assertTrue(inn.length() == 10 || inn.length() == 12);
            assertTrue(inn.matches("\\d+"));
        }
    }
    
    @Test
    void testGenerateLegalInn() {
        InnOptions options = new InnOptions(InnOptions.Kind.LEGAL);
        for (int i = 0; i < 100; i++) {
            String inn = generator.generate(options);
            assertEquals(10, inn.length());
        }
    }
    
    @Test
    void testGenerateIndividualInn() {
        InnOptions options = new InnOptions(InnOptions.Kind.INDIVIDUAL);
        for (int i = 0; i < 100; i++) {
            String inn = generator.generate(options);
            assertEquals(12, inn.length());
        }
    }
    
    @Test
    void testGenerateWithRegion() {
        InnOptions options = new InnOptions("78");
        String inn = generator.generate(options);
        assertTrue(inn.startsWith("78"));
    }
    
    @Test
    void testSequenceConsistency() {
        InnOptions options = new InnOptions(12345L);
        String inn1 = generator.generate(options);
        String inn2 = generator.generate(options);
        assertEquals(inn1, inn2);
    }
    
    @Test
    void testInvalidRegion() {
        InnOptions options = new InnOptions("99");
        assertThrows(IllegalArgumentException.class, () -> generator.generate(options));
    }
}