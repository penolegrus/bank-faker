package io.github.penolegrus.generators;

import io.github.penolegrus.SequenceUtils;
import java.util.Random;

/**
 * Generator for settlement accounts (расчётный счёт)
 */
public class SettlementAccountGenerator {
    
    public String generate() {
        return generate(new SettlementAccountOptions());
    }
    
    public String generate(SettlementAccountOptions options) {
        Random random = SequenceUtils.getSequenceRandom(options.getSequenceNumber());
        String okvDigits = SequenceUtils.findOkv(options.getOkv(), random);
        
        return String.format("%05d", random.nextInt(100_000)) + 
               okvDigits + 
               String.format("%012d", random.nextInt(1_000_000_000));
    }
}