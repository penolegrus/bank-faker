package thread.qa.bankfaker.generators;

import thread.qa.bankfaker.Constants;
import thread.qa.bankfaker.SequenceUtils;
import java.util.Random;

/**
 * Generator for INN (Individual Taxpayer Number)
 */
public class InnGenerator {
    
    private static final int[] P10 = {2, 4, 10, 3, 5, 9, 4, 6, 8};
    private static final int[] P11 = {7, 2, 4, 10, 3, 5, 9, 4, 6, 8};
    private static final int[] P12 = {3, 7, 2, 4, 10, 3, 5, 9, 4, 6, 8};
    
    public String generate() {
        return generate(new InnOptions());
    }
    
    public String generate(InnOptions options) {
        Random random = SequenceUtils.getSequenceRandom(options.getSequenceNumber());
        String regionNumber = SequenceUtils.findRegionNumber(
            options.getRegionNumber(), 
            random, 
            Constants.REGION_NUMBERS
        );
        
        InnOptions.Kind kind = findKind(options.getKind(), random);
        String sequenceDigits = findDigits(kind, random);
        
        String innWithoutCheckDigit = regionNumber + sequenceDigits;
        return innWithoutCheckDigit + calculateCheckDigit(innWithoutCheckDigit);
    }
    
    private InnOptions.Kind findKind(InnOptions.Kind kind, Random random) {
        if (kind != null) {
            return kind;
        }
        return random.nextBoolean() ? InnOptions.Kind.INDIVIDUAL : InnOptions.Kind.LEGAL;
    }
    
    private String findDigits(InnOptions.Kind kind, Random random) {
        if (kind == InnOptions.Kind.LEGAL) {
            return String.format("%07d", random.nextInt(9_000_000) + 1_000_000);
        } else {
            return String.format("%08d", random.nextInt(90_000_000) + 10_000_000);
        }
    }
    
    private String calculateCheckDigit(String digits) {
        if (digits.length() == 9) {
            return calculateInn(P10, digits);
        } else {
            String firstCheck = calculateInn(P11, digits);
            return firstCheck + calculateInn(P12, digits + firstCheck);
        }
    }
    
    private String calculateInn(int[] coefficients, String inn) {
        int sum = 0;
        for (int i = 0; i < coefficients.length; i++) {
            sum += coefficients[i] * Character.getNumericValue(inn.charAt(i));
        }
        return String.valueOf((sum % 11) % 10);
    }
}