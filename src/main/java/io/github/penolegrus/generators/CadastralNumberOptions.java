package io.github.penolegrus.generators;

public class CadastralNumberOptions extends BaseOptions {
    private Integer district;
    private Integer area;
    private String quarter;
    
    public CadastralNumberOptions() {}
    
    public CadastralNumberOptions(Long sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }
    
    public CadastralNumberOptions(Integer district, Integer area, String quarter) {
        this.district = district;
        this.area = area;
        this.quarter = quarter;
    }
    
    public CadastralNumberOptions(Long sequenceNumber, Integer district, Integer area, String quarter) {
        this.sequenceNumber = sequenceNumber;
        this.district = district;
        this.area = area;
        this.quarter = quarter;
    }
    
    public Integer getDistrict() {
        return district;
    }
    
    public void setDistrict(Integer district) {
        this.district = district;
    }
    
    public Integer getArea() {
        return area;
    }
    
    public void setArea(Integer area) {
        this.area = area;
    }
    
    public String getQuarter() {
        return quarter;
    }
    
    public void setQuarter(String quarter) {
        this.quarter = quarter;
    }
}