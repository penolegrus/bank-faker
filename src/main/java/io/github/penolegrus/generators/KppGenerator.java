package io.github.penolegrus.generators;

import io.github.penolegrus.Constants;
import io.github.penolegrus.SequenceUtils;
import java.util.Random;

/**
 * Generator for KPP (Tax Registration Reason Code)
 */
public class KppGenerator {
    
    public String generate() {
        return generate(new KppOptions());
    }
    
    public String generate(KppOptions options) {
        Random random = SequenceUtils.getSequenceRandom(options.getSequenceNumber());
        String regionNumber = SequenceUtils.findRegionNumber(
            options.getRegionNumber(), 
            random, 
            Constants.REGION_NUMBERS
        );
        
        String twoRegionNumbers = String.format("%02d", random.nextInt(100));
        return regionNumber + twoRegionNumbers + "01001";
    }
}