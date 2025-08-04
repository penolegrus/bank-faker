package thread.qa.bankfaker.generators;

import thread.qa.bankfaker.Constants;
import thread.qa.bankfaker.SequenceUtils;
import java.util.Random;

/**
 * Generator for OKATO (All-Russian Classifier of Administrative-Territorial Division Objects)
 */
public class OkatoGenerator {
    
    private static final int[] VALID_LENGTHS = {3, 6, 9};
    
    public String generate() {
        return generate(new OkatoOptions());
    }
    
    public String generate(OkatoOptions options) {
        Random random = SequenceUtils.getSequenceRandom(options.getSequenceNumber());
        String okatoRegionNumber = SequenceUtils.findRegionNumber(
            options.getOkatoRegionNumber(), 
            random, 
            Constants.OKATO_REGION_NUMBERS
        );
        
        String lengthDigits = findLengthDigits(options.getLength(), random);
        String okatoWithoutCalc = okatoRegionNumber + lengthDigits;
        return okatoWithoutCalc + calculateOkato(okatoWithoutCalc);
    }
    
    private String findLengthDigits(Integer length, Random random) {
        int targetLength = length != null ? length : VALID_LENGTHS[random.nextInt(3)];
        
        if (targetLength != 3 && targetLength != 6 && targetLength != 9) {
            throw new IllegalArgumentException("Invalid OKATO length: " + targetLength);
        }
        
        if (targetLength == 3) {
            return "";
        }
        
        String digits = String.format("%06d", random.nextInt(1_000_000));
        return digits.substring(0, targetLength - 3);
    }
    
    private String calculateOkato(String okatoWithoutCalc) {
        int calc1 = calculateOkatoDigit(okatoWithoutCalc, 1);
        if (calc1 < 10) {
            return String.valueOf(calc1);
        } else {
            return String.valueOf(calculateOkatoDigit(okatoWithoutCalc, 3) % 10);
        }
    }
    
    private int calculateOkatoDigit(String okatoWithoutCalc, int addingNumber) {
        int sum = 0;
        for (int i = 0; i < okatoWithoutCalc.length(); i++) {
            sum += Character.getNumericValue(okatoWithoutCalc.charAt(i)) * (i + addingNumber);
        }
        return sum % 11;
    }
}