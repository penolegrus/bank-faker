package io.github.penolegrus.generators;

import io.github.penolegrus.Constants;
import io.github.penolegrus.SequenceUtils;
import java.time.LocalDate;
import java.util.Random;

/**
 * Generator for OGRN (Primary State Registration Number)
 */
public class OgrnGenerator {
    
    private static final int[] LEGAL_SIGN_OF_REG_NUMS = {1, 5};
    private static final int INDIVIDUAL_SIGN_OF_REG_NUM = 4;
    
    public String generate() {
        return generate(new OgrnOptions());
    }
    
    public String generate(OgrnOptions options) {
        Random random = SequenceUtils.getSequenceRandom(options.getSequenceNumber());
        OgrnOptions.Kind kind = findKind(options.getKind(), random);
        
        int signOfRegNum = findSignOfRegNum(kind, random);
        String yearNumber = getYearNumber(random);
        String regionNumber = SequenceUtils.findRegionNumber(
            options.getRegionNumber(), 
            random, 
            Constants.REGION_NUMBERS
        );
        String taxOfficeCode = findTaxOfficeCode(kind, random);
        String recordNumber = findDigits(kind, random);
        
        String ogrnWithoutCheckDigit = signOfRegNum + yearNumber + regionNumber + taxOfficeCode + recordNumber;
        return ogrnWithoutCheckDigit + calculateCheckDigit(ogrnWithoutCheckDigit);
    }
    
    private OgrnOptions.Kind findKind(OgrnOptions.Kind kind, Random random) {
        if (kind != null) {
            return kind;
        }
        return random.nextBoolean() ? OgrnOptions.Kind.LEGAL : OgrnOptions.Kind.INDIVIDUAL;
    }
    
    private int findSignOfRegNum(OgrnOptions.Kind kind, Random random) {
        if (kind == OgrnOptions.Kind.LEGAL) {
            return LEGAL_SIGN_OF_REG_NUMS[random.nextInt(2)];
        }
        return INDIVIDUAL_SIGN_OF_REG_NUM;
    }
    
    private String getYearNumber(Random random) {
        int currentYear = LocalDate.now().getYear();
        int year = random.nextInt(currentYear - 2000 + 1) + 2000;
        return String.format("%02d", year % 100);
    }
    
    private String findTaxOfficeCode(OgrnOptions.Kind kind, Random random) {
        if (kind == OgrnOptions.Kind.LEGAL) {
            return String.format("%02d", random.nextInt(90) + 10);
        }
        return "";
    }
    
    private String findDigits(OgrnOptions.Kind kind, Random random) {
        if (kind == OgrnOptions.Kind.LEGAL) {
            return String.format("%05d", random.nextInt(90_000) + 10_000);
        } else {
            return String.format("%09d", random.nextInt(900_000_000) + 100_000_000);
        }
    }
    
    private String calculateCheckDigit(String digits) {
        long number = Long.parseLong(digits);
        int divisor = digits.length() - 1;
        return String.valueOf((number % divisor) % 10);
    }
}