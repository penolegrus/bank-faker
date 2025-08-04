package io.github.penolegrus.generators;

import io.github.penolegrus.SequenceUtils;
import java.util.Random;

/**
 * Generator for correspondent accounts
 */
public class CorrespondentAccountGenerator {
    
    public String generate() {
        return generate(new CorrespondentAccountOptions());
    }
    
    public String generate(CorrespondentAccountOptions options) {
        Random random = SequenceUtils.getSequenceRandom(options.getSequenceNumber());
        String memberNumber = findMemberNumber(options.getBik(), random);
        
        return "301" + String.format("%014d", random.nextInt(1_000_000_000)) + memberNumber;
    }
    
    private String findMemberNumber(String bik, Random random) {
        if (bik != null && bik.length() > 3) {
            return bik.substring(bik.length() - 3);
        } else {
            return String.format("%03d", random.nextInt(1_000));
        }
    }
}