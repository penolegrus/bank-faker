package io.github.penolegrus.generators;

import io.github.penolegrus.SequenceUtils;
import java.util.Random;

/**
 * Generator for OKPO (All-Russian Classifier of Enterprises and Organizations)
 */
public class OkpoGenerator {
    
    public String generate() {
        return generate(new OkpoOptions());
    }
    
    public String generate(OkpoOptions options) {
        Random random = SequenceUtils.getSequenceRandom(options.getSequenceNumber());
        String okpoDigits = generateOkpoDigits(random);
        return okpoDigits + calculateCheckDigit(okpoDigits);
    }
    
    private String generateOkpoDigits(Random random) {
        if (random.nextBoolean()) {
            return String.format("%07d", random.nextInt(10_000_000));
        } else {
            return String.format("%09d", random.nextInt(1_000_000_000));
        }
    }
    
    private String calculateCheckDigit(String okpoDigits) {
        int sum = 0;
        for (int i = 0; i < okpoDigits.length(); i++) {
            sum += Character.getNumericValue(okpoDigits.charAt(i)) * (i + 1);
        }
        return String.valueOf((sum % 11) % 10);
    }
}