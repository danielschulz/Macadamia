package de.novensa.cs.performance.macadamia.management.jvm.util;

/**
 * Get the detailed versioned information about the JVM resources.
 *
 * @author Daniel Schulz
 */
public class JvmResourceDetails {

    private final long timeStamp;


    // constructor
    public JvmResourceDetails() {
        this.timeStamp = System.nanoTime();
    }

    // getter
    public long getTimeStamp() {
        return timeStamp;
    }
}
