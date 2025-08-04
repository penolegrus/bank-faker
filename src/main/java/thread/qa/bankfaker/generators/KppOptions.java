package thread.qa.bankfaker.generators;

public class KppOptions extends BaseOptions {
    private String regionNumber;
    
    public KppOptions() {}
    
    public KppOptions(Long sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }
    
    public KppOptions(String regionNumber) {
        this.regionNumber = regionNumber;
    }
    
    public KppOptions(Long sequenceNumber, String regionNumber) {
        this.sequenceNumber = sequenceNumber;
        this.regionNumber = regionNumber;
    }
    
    public String getRegionNumber() {
        return regionNumber;
    }
    
    public void setRegionNumber(String regionNumber) {
        this.regionNumber = regionNumber;
    }
}