package io.github.penolegrus.generators;

public class CorrespondentAccountOptions extends BaseOptions {
    private String bik;
    
    public CorrespondentAccountOptions() {}
    
    public CorrespondentAccountOptions(Long sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }
    
    public CorrespondentAccountOptions(String bik) {
        this.bik = bik;
    }
    
    public CorrespondentAccountOptions(Long sequenceNumber, String bik) {
        this.sequenceNumber = sequenceNumber;
        this.bik = bik;
    }
    
    public String getBik() {
        return bik;
    }
    
    public void setBik(String bik) {
        this.bik = bik;
    }
}