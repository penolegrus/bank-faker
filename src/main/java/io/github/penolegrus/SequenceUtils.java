package io.github.penolegrus;

import java.util.Random;

/**
 * Utility class for handling sequence-based random generation
 */
public class SequenceUtils {
    
    /**
     * Creates a Random instance based on sequence number or returns a new random instance
     */
    public static Random getSequenceRandom(Long sequenceNumber) {
        if (sequenceNumber != null) {
            return new Random(sequenceNumber);
        }
        return new Random();
    }
    
    /**
     * Finds region number from array based on provided number or random selection
     */
    public static String findRegionNumber(String regionNumber, Random random, String[] regionNumbers) {
        if (regionNumber != null && !regionNumber.isEmpty()) {
            // Validate that the region number exists
            for (String validRegion : regionNumbers) {
                if (validRegion.equals(regionNumber)) {
                    return regionNumber;
                }
            }
            throw new IllegalArgumentException("Invalid region number: " + regionNumber);
        }
        return regionNumbers[random.nextInt(regionNumbers.length)];
    }
    
    /**
     * Finds OKV code from array based on provided code or random selection
     */
    public static String findOkv(String okv, Random random) {
        if (okv != null && !okv.isEmpty()) {
            // Validate that the OKV exists
            for (String validOkv : Constants.OKV) {
                if (validOkv.equals(okv)) {
                    return okv;
                }
            }
            throw new IllegalArgumentException("Invalid OKV: " + okv);
        }
        return Constants.OKV[random.nextInt(Constants.OKV.length)];
    }
    
    private SequenceUtils() {
        // Utility class
    }
}