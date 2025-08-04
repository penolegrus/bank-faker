package thread.qa.bankfaker.generators;

import thread.qa.bankfaker.SequenceUtils;
import java.util.Random;

/**
 * Generator for SNILS (Individual Insurance Account Number)
 */
public class SnilsGenerator {
    
    public String generate() {
        return generate(new SnilsOptions());
    }
    
    public String generate(SnilsOptions options) {
        Random random = SequenceUtils.getSequenceRandom(options.getSequenceNumber());
        String snilsDigits = String.format("%09d", random.nextInt(1_000_000_000));
        return snilsDigits + calculateCheckDigits(snilsDigits);
    }
    
    private String calculateCheckDigits(String snilsDigits) {
        int sum = 0;
        for (int i = 0; i < snilsDigits.length(); i++) {
            sum += Character.getNumericValue(snilsDigits.charAt(i)) * (9 - i);
        }
        int checksum = (sum % 101) % 100;
        return String.format("%02d", checksum);
    }
}