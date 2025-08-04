package io.github.penolegrus.generators;

/**
 * Options for INN generation
 */
public class InnOptions extends BaseOptions {
    
    public enum Kind {
        INDIVIDUAL, LEGAL
    }
    
    private String regionNumber;
    private Kind kind;
    
    public InnOptions() {}
    
    public InnOptions(Long sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }
    
    public InnOptions(String regionNumber) {
        this.regionNumber = regionNumber;
    }
    
    public InnOptions(Kind kind) {
        this.kind = kind;
    }
    
    public InnOptions(String regionNumber, Kind kind) {
        this.regionNumber = regionNumber;
        this.kind = kind;
    }
    
    public InnOptions(Long sequenceNumber, String regionNumber, Kind kind) {
        this.sequenceNumber = sequenceNumber;
        this.regionNumber = regionNumber;
        this.kind = kind;
    }
    
    public String getRegionNumber() {
        return regionNumber;
    }
    
    public void setRegionNumber(String regionNumber) {
        this.regionNumber = regionNumber;
    }
    
    public Kind getKind() {
        return kind;
    }
    
    public void setKind(Kind kind) {
        this.kind = kind;
    }
}