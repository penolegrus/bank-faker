package io.github.penolegrus;

import io.github.penolegrus.generators.*;
import org.junit.jupiter.api.Test;

/**
 * Examples of using FakerRussian library
 */
class ExamplesTest {
    
    @Test
    void basicUsageExamples() {
        FakerRussian faker = new FakerRussian();
        
        // Basic generation
        System.out.println("=== Basic Generation ===");
        System.out.println("INN: " + faker.inn());
        System.out.println("BIK: " + faker.bik());
        System.out.println("OGRN: " + faker.ogrn());
        System.out.println("KPP: " + faker.kpp());
        System.out.println("OKPO: " + faker.okpo());
        System.out.println("SNILS: " + faker.snils());
        System.out.println("OKATO: " + faker.okato());
        System.out.println("Correspondent Account: " + faker.correspondentAccount());
        System.out.println("Settlement Account: " + faker.settlementAccount());
        System.out.println("Cadastral Number: " + faker.cadastralNumber());
    }
    
    @Test
    void advancedUsageExamples() {
        FakerRussian faker = new FakerRussian();
        
        System.out.println("\n=== Advanced Usage ===");
        
        // INN with specific parameters
        System.out.println("Legal INN: " + faker.inn(new InnOptions(InnOptions.Kind.LEGAL)));
        System.out.println("Individual INN: " + faker.inn(new InnOptions(InnOptions.Kind.INDIVIDUAL)));
        System.out.println("Moscow region INN: " + faker.inn(new InnOptions("77")));
        
        // BIK for specific region
        System.out.println("SPb BIK: " + faker.bik(new BikOptions("78")));
        
        // OGRN with specific type
        System.out.println("Legal OGRN: " + faker.ogrn(new OgrnOptions(OgrnOptions.Kind.LEGAL)));
        System.out.println("Individual OGRN: " + faker.ogrn(new OgrnOptions(OgrnOptions.Kind.INDIVIDUAL)));
        
        // OKATO with specific length
        System.out.println("OKATO 3 digits: " + faker.okato(new OkatoOptions(3)));
        System.out.println("OKATO 6 digits: " + faker.okato(new OkatoOptions(6)));
        System.out.println("OKATO 9 digits: " + faker.okato(new OkatoOptions(9)));
        
        // Correspondent account for specific BIK
        String bik = faker.bik();
        System.out.println("BIK: " + bik);
        System.out.println("Correspondent Account for BIK: " + 
            faker.correspondentAccount(new CorrespondentAccountOptions(bik)));
        
        // Settlement account with specific OKV
        System.out.println("Settlement Account (RUB): " + 
            faker.settlementAccount(new SettlementAccountOptions("810")));
        
        // Cadastral number with specific parameters
        System.out.println("Moscow cadastral: " + 
            faker.cadastralNumber(new CadastralNumberOptions(77, 1, "123456")));
    }
    
    @Test
    void sequenceExamples() {
        FakerRussian faker = new FakerRussian();
        
        System.out.println("\n=== Sequence Examples ===");
        
        Long sequence = 12345L;
        
        // Same sequence produces same results
        System.out.println("INN with sequence " + sequence + ": " + 
            faker.inn(new InnOptions(sequence)));
        System.out.println("INN with sequence " + sequence + " (repeat): " + 
            faker.inn(new InnOptions(sequence)));
        
        System.out.println("BIK with sequence " + sequence + ": " + 
            faker.bik(new BikOptions(sequence)));
        System.out.println("BIK with sequence " + sequence + " (repeat): " + 
            faker.bik(new BikOptions(sequence)));
        
        // Different sequences produce different results
        System.out.println("INN with sequence 1: " + faker.inn(new InnOptions(1L)));
        System.out.println("INN with sequence 2: " + faker.inn(new InnOptions(2L)));
        System.out.println("INN with sequence 3: " + faker.inn(new InnOptions(3L)));
    }
    
    @Test
    void bankingDataSetExample() {
        FakerRussian faker = new FakerRussian();
        
        System.out.println("\n=== Banking Data Set Example ===");
        
        // Generate a complete set of banking data
        String bik = faker.bik(new BikOptions("78")); // SPb region
        String correspondentAccount = faker.correspondentAccount(new CorrespondentAccountOptions(bik));
        String legalInn = faker.inn(new InnOptions("78", InnOptions.Kind.LEGAL));
        String kpp = faker.kpp(new KppOptions("78"));
        String ogrn = faker.ogrn(new OgrnOptions("78", OgrnOptions.Kind.LEGAL));
        String okpo = faker.okpo();
        String settlementAccount = faker.settlementAccount(new SettlementAccountOptions("810"));
        
        System.out.println("Bank Data Set:");
        System.out.println("  BIK: " + bik);
        System.out.println("  Correspondent Account: " + correspondentAccount);
        System.out.println("  Legal Entity INN: " + legalInn);
        System.out.println("  KPP: " + kpp);
        System.out.println("  OGRN: " + ogrn);
        System.out.println("  OKPO: " + okpo);
        System.out.println("  Settlement Account: " + settlementAccount);
    }
}