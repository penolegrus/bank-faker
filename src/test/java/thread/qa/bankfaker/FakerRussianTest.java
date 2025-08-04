package thread.qa.bankfaker;

import thread.qa.bankfaker.generators.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FakerRussianTest {
    
    private FakerRussian faker;
    
    @BeforeEach
    void setUp() {
        faker = new FakerRussian();
    }
    
    @Test
    void testBikGeneration() {
        String bik = faker.bik();
        assertNotNull(bik);
        assertEquals(9, bik.length());
        assertTrue(bik.startsWith("04"));
    }
    
    @Test
    void testBikWithOptions() {
        BikOptions options = new BikOptions("78");
        String bik = faker.bik(options);
        assertNotNull(bik);
        assertEquals(9, bik.length());
        assertTrue(bik.startsWith("0478"));
    }
    
    @Test
    void testInnGeneration() {
        String inn = faker.inn();
        assertNotNull(inn);
        assertTrue(inn.length() == 10 || inn.length() == 12);
    }
    
    @Test
    void testInnWithKind() {
        InnOptions legalOptions = new InnOptions(InnOptions.Kind.LEGAL);
        String legalInn = faker.inn(legalOptions);
        assertEquals(10, legalInn.length());
        
        InnOptions individualOptions = new InnOptions(InnOptions.Kind.INDIVIDUAL);
        String individualInn = faker.inn(individualOptions);
        assertEquals(12, individualInn.length());
    }
    
    @Test
    void testKppGeneration() {
        String kpp = faker.kpp();
        assertNotNull(kpp);
        assertEquals(9, kpp.length());
        assertTrue(kpp.endsWith("01001"));
    }
    
    @Test
    void testOgrnGeneration() {
        String ogrn = faker.ogrn();
        assertNotNull(ogrn);
        assertTrue(ogrn.length() == 13 || ogrn.length() == 15);
    }
    
    @Test
    void testOkpoGeneration() {
        String okpo = faker.okpo();
        assertNotNull(okpo);
        assertTrue(okpo.length() == 8 || okpo.length() == 10);
    }
    
    @Test
    void testSnilsGeneration() {
        String snils = faker.snils();
        assertNotNull(snils);
        assertEquals(11, snils.length());
    }
    
    @Test
    void testOkatoGeneration() {
        String okato = faker.okato();
        assertNotNull(okato);
        assertTrue(okato.length() >= 3 && okato.length() <= 9);
    }
    
    @Test
    void testCorrespondentAccountGeneration() {
        String account = faker.correspondentAccount();
        assertNotNull(account);
        assertEquals(20, account.length());
        assertTrue(account.startsWith("301"));
    }
    
    @Test
    void testSettlementAccountGeneration() {
        String account = faker.settlementAccount();
        assertNotNull(account);
        assertEquals(20, account.length());
    }
    
    @Test
    void testCadastralNumberGeneration() {
        String cadastralNumber = faker.cadastralNumber();
        assertNotNull(cadastralNumber);
        assertTrue(cadastralNumber.contains(":"));
        String[] parts = cadastralNumber.split(":");
        assertEquals(4, parts.length);
    }
    
    @Test
    void testSequenceConsistency() {
        // Test that same sequence number produces same results
        Long sequenceNumber = 12345L;
        
        String inn1 = faker.inn(new InnOptions(sequenceNumber));
        String inn2 = faker.inn(new InnOptions(sequenceNumber));
        assertEquals(inn1, inn2);
        
        String bik1 = faker.bik(new BikOptions(sequenceNumber));
        String bik2 = faker.bik(new BikOptions(sequenceNumber));
        assertEquals(bik1, bik2);
    }
}