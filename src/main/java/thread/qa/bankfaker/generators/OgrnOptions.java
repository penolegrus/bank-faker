package thread.qa.bankfaker.generators;

public class OgrnOptions extends BaseOptions {
    
    public enum Kind {
        LEGAL, INDIVIDUAL
    }
    
    private String regionNumber;
    private Kind kind;
    
    public OgrnOptions() {}
    
    public OgrnOptions(Long sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }
    
    public OgrnOptions(String regionNumber) {
        this.regionNumber = regionNumber;
    }
    
    public OgrnOptions(Kind kind) {
        this.kind = kind;
    }
    
    public OgrnOptions(String regionNumber, Kind kind) {
        this.regionNumber = regionNumber;
        this.kind = kind;
    }
    
    public OgrnOptions(Long sequenceNumber, String regionNumber, Kind kind) {
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