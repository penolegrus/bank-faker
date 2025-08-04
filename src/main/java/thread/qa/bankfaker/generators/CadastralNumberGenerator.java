package thread.qa.bankfaker.generators;

import thread.qa.bankfaker.SequenceUtils;
import java.util.Random;

/**
 * Generator for cadastral numbers
 */
public class CadastralNumberGenerator {
    
    public String generate() {
        return generate(new CadastralNumberOptions());
    }
    
    public String generate(CadastralNumberOptions options) {
        Random random = SequenceUtils.getSequenceRandom(options.getSequenceNumber());
        
        String district = formatNumber(options.getDistrict() != null ? 
            options.getDistrict() : cadastralDistrict(random));
        String area = formatNumber(options.getArea() != null ? 
            options.getArea() : cadastralArea(random));
        String quarter = options.getQuarter() != null ? 
            options.getQuarter() : String.valueOf(cadastralQuarter(random));
        
        return district + ":" + area + ":" + quarter + ":" + propertyNumber(random);
    }
    
    private int cadastralDistrict(Random random) {
        return random.nextInt(91) + 1;
    }
    
    private int cadastralArea(Random random) {
        return random.nextInt(99) + 1;
    }
    
    private int cadastralQuarter(Random random) {
        return random.nextBoolean() ? 
            random.nextInt(900_000) + 100_000 : 
            random.nextInt(9_000_000) + 1_000_000;
    }
    
    private int propertyNumber(Random random) {
        return random.nextInt(99_999) + 1;
    }
    
    private String formatNumber(int number) {
        String numberStr = String.valueOf(number);
        if (numberStr.length() == 1 && !numberStr.equals("0")) {
            return "0" + numberStr;
        }
        return numberStr;
    }
}