package thread.qa.bankfaker.generators;

public class OkatoOptions extends BaseOptions {
    private String okatoRegionNumber;
    private Integer length;
    
    public OkatoOptions() {}
    
    public OkatoOptions(Long sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }
    
    public OkatoOptions(String okatoRegionNumber) {
        this.okatoRegionNumber = okatoRegionNumber;
    }
    
    public OkatoOptions(Integer length) {
        this.length = length;
    }
    
    public OkatoOptions(Long sequenceNumber, String okatoRegionNumber, Integer length) {
        this.sequenceNumber = sequenceNumber;
        this.okatoRegionNumber = okatoRegionNumber;
        this.length = length;
    }
    
    public String getOkatoRegionNumber() {
        return okatoRegionNumber;
    }
    
    public void setOkatoRegionNumber(String okatoRegionNumber) {
        this.okatoRegionNumber = okatoRegionNumber;
    }
    
    public Integer getLength() {
        return length;
    }
    
    public void setLength(Integer length) {
        this.length = length;
    }
}