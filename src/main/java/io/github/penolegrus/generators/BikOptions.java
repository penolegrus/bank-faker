package io.github.penolegrus.generators;

/**
 * Options for BIK generation
 */
public class BikOptions extends BaseOptions {
    private String okatoRegionNumber;
    
    public BikOptions() {}
    
    public BikOptions(Long sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }
    
    public BikOptions(String okatoRegionNumber) {
        this.okatoRegionNumber = okatoRegionNumber;
    }
    
    public BikOptions(Long sequenceNumber, String okatoRegionNumber) {
        this.sequenceNumber = sequenceNumber;
        this.okatoRegionNumber = okatoRegionNumber;
    }
    
    public String getOkatoRegionNumber() {
        return okatoRegionNumber;
    }
    
    public void setOkatoRegionNumber(String okatoRegionNumber) {
        this.okatoRegionNumber = okatoRegionNumber;
    }
}