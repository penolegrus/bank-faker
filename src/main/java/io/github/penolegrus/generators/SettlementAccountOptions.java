package io.github.penolegrus.generators;

public class SettlementAccountOptions extends BaseOptions {
    private String okv;
    
    public SettlementAccountOptions() {}
    
    public SettlementAccountOptions(Long sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }
    
    public SettlementAccountOptions(String okv) {
        this.okv = okv;
    }
    
    public SettlementAccountOptions(Long sequenceNumber, String okv) {
        this.sequenceNumber = sequenceNumber;
        this.okv = okv;
    }
    
    public String getOkv() {
        return okv;
    }
    
    public void setOkv(String okv) {
        this.okv = okv;
    }
}