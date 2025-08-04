package io.github.penolegrus.generators;

/**
 * Base class for all generator options
 */
public abstract class BaseOptions {
    protected Long sequenceNumber;
    
    public Long getSequenceNumber() {
        return sequenceNumber;
    }
    
    public void setSequenceNumber(Long sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }
}