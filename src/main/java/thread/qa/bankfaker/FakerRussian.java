package thread.qa.bankfaker;

import thread.qa.bankfaker.generators.*;

/**
 * Main class for generating Russian-specific fake data.
 * Supports generation of INN, OGRN, BIK, KPP, OKPO, SNILS, OKATO, 
 * correspondent accounts, settlement accounts, and cadastral numbers.
 * 
 * <p>Example usage:</p>
 * <pre>
 * FakerRussian faker = new FakerRussian();
 * String inn = faker.inn();
 * String bik = faker.bik();
 * String ogrn = faker.ogrn(new OgrnOptions(OgrnOptions.Kind.LEGAL));
 * </pre>
 */
public class FakerRussian {
    
    private final BikGenerator bikGenerator;
    private final InnGenerator innGenerator;
    private final KppGenerator kppGenerator;
    private final OgrnGenerator ogrnGenerator;
    private final OkpoGenerator okpoGenerator;
    private final SnilsGenerator snilsGenerator;
    private final OkatoGenerator okatoGenerator;
    private final CorrespondentAccountGenerator correspondentAccountGenerator;
    private final SettlementAccountGenerator settlementAccountGenerator;
    private final CadastralNumberGenerator cadastralNumberGenerator;
    
    /**
     * Creates a new FakerRussian instance with default generators
     */
    public FakerRussian() {
        this.bikGenerator = new BikGenerator();
        this.innGenerator = new InnGenerator();
        this.kppGenerator = new KppGenerator();
        this.ogrnGenerator = new OgrnGenerator();
        this.okpoGenerator = new OkpoGenerator();
        this.snilsGenerator = new SnilsGenerator();
        this.okatoGenerator = new OkatoGenerator();
        this.correspondentAccountGenerator = new CorrespondentAccountGenerator();
        this.settlementAccountGenerator = new SettlementAccountGenerator();
        this.cadastralNumberGenerator = new CadastralNumberGenerator();
    }
    
    /**
     * Generate BIK (Bank Identification Code)
     */
    public String bik() {
        return bikGenerator.generate();
    }
    
    public String bik(BikOptions options) {
        return bikGenerator.generate(options);
    }
    
    /**
     * Generate INN (Individual Taxpayer Number)
     */
    public String inn() {
        return innGenerator.generate();
    }
    
    public String inn(InnOptions options) {
        return innGenerator.generate(options);
    }
    
    /**
     * Generate KPP (Tax Registration Reason Code)
     */
    public String kpp() {
        return kppGenerator.generate();
    }
    
    public String kpp(KppOptions options) {
        return kppGenerator.generate(options);
    }
    
    /**
     * Generate OGRN (Primary State Registration Number)
     */
    public String ogrn() {
        return ogrnGenerator.generate();
    }
    
    public String ogrn(OgrnOptions options) {
        return ogrnGenerator.generate(options);
    }
    
    /**
     * Generate OKPO (All-Russian Classifier of Enterprises and Organizations)
     */
    public String okpo() {
        return okpoGenerator.generate();
    }
    
    public String okpo(OkpoOptions options) {
        return okpoGenerator.generate(options);
    }
    
    /**
     * Generate SNILS (Individual Insurance Account Number)
     */
    public String snils() {
        return snilsGenerator.generate();
    }
    
    public String snils(SnilsOptions options) {
        return snilsGenerator.generate(options);
    }
    
    /**
     * Generate OKATO (All-Russian Classifier of Administrative-Territorial Division Objects)
     */
    public String okato() {
        return okatoGenerator.generate();
    }
    
    public String okato(OkatoOptions options) {
        return okatoGenerator.generate(options);
    }
    
    /**
     * Generate correspondent account
     */
    public String correspondentAccount() {
        return correspondentAccountGenerator.generate();
    }
    
    public String correspondentAccount(CorrespondentAccountOptions options) {
        return correspondentAccountGenerator.generate(options);
    }
    
    /**
     * Generate settlement account (расчётный счёт)
     */
    public String settlementAccount() {
        return settlementAccountGenerator.generate();
    }
    
    public String settlementAccount(SettlementAccountOptions options) {
        return settlementAccountGenerator.generate(options);
    }
    
    /**
     * Generate cadastral number
     */
    public String cadastralNumber() {
        return cadastralNumberGenerator.generate();
    }
    
    public String cadastralNumber(CadastralNumberOptions options) {
        return cadastralNumberGenerator.generate(options);
    }
}