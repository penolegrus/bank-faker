package thread.qa.bankfaker.generators;

import thread.qa.bankfaker.Constants;
import thread.qa.bankfaker.SequenceUtils;
import java.util.Random;

/**
 * Generator for BIK (Bank Identification Code)
 */
public class BikGenerator {
    
    public String generate() {
        return generate(new BikOptions());
    }
    
    public String generate(BikOptions options) {
        Random random = SequenceUtils.getSequenceRandom(options.getSequenceNumber());
        String okatoRegionNumber = SequenceUtils.findRegionNumber(
            options.getOkatoRegionNumber(), 
            random, 
            Constants.OKATO_REGION_NUMBERS
        );
        
        return "04" + okatoRegionNumber + String.format("%05d", random.nextInt(100_000));
    }
}