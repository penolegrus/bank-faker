package io.github.penolegrus;

import io.github.penolegrus.generators.*;

/**
 * Example usage of FakerRussian library
 */
public class Example {
    
    public static void main(String[] args) {
        FakerRussian faker = new FakerRussian();
        
        System.out.println("=== Bank Faker Russian Example ===\n");
        
        // Basic generation
        System.out.println("Basic generation:");
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
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        // Advanced usage with options
        System.out.println("Advanced usage with options:");
        
        // Legal entity data for Moscow region
        String moscowRegion = "77";
        System.out.println("Moscow Legal Entity:");
        System.out.println("  INN: " + faker.inn(new InnOptions(moscowRegion, InnOptions.Kind.LEGAL)));
        System.out.println("  KPP: " + faker.kpp(new KppOptions(moscowRegion)));
        System.out.println("  OGRN: " + faker.ogrn(new OgrnOptions(moscowRegion, OgrnOptions.Kind.LEGAL)));
        
        // Individual data for SPb region
        String spbRegion = "78";
        System.out.println("\nSPb Individual:");
        System.out.println("  INN: " + faker.inn(new InnOptions(spbRegion, InnOptions.Kind.INDIVIDUAL)));
        System.out.println("  OGRN: " + faker.ogrn(new OgrnOptions(spbRegion, OgrnOptions.Kind.INDIVIDUAL)));
        System.out.println("  SNILS: " + faker.snils());
        
        // Banking data
        String bik = faker.bik(new BikOptions(spbRegion));
        System.out.println("\nBanking data:");
        System.out.println("  BIK: " + bik);
        System.out.println("  Correspondent Account: " + faker.correspondentAccount(new CorrespondentAccountOptions(bik)));
        System.out.println("  Settlement Account (RUB): " + faker.settlementAccount(new SettlementAccountOptions("810")));
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        // Deterministic generation
        System.out.println("Deterministic generation (same sequence = same result):");
        Long sequence = 12345L;
        System.out.println("Sequence " + sequence + ":");
        System.out.println("  INN (1st call): " + faker.inn(new InnOptions(sequence)));
        System.out.println("  INN (2nd call): " + faker.inn(new InnOptions(sequence)));
        System.out.println("  BIK (1st call): " + faker.bik(new BikOptions(sequence)));
        System.out.println("  BIK (2nd call): " + faker.bik(new BikOptions(sequence)));
    }
}