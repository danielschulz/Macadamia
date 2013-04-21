package de.novensa.cs.performance.macadamia.management.jvm;

/**
 * This class finds out what resource is to what extend precious and therefore provides hints if the implementation
 * can reach the target in a different approach. An example may be using <code>Radix-Sort</code> when CPU time is
 * crucial and <code>Collections.sort</code> or <code>Arrays.sort</code> (both merge sort) when memory is crucial to
 * a higher extend.
 *
 * @author Daniel Schulz
 */
public class CrucialJvmResources {

    private final long timeStamp;
    private final JvmResourceDetailsContainer jvmResourceDetailsContainer;

    public CrucialJvmResources() {
        this.timeStamp = System.nanoTime();
        this.jvmResourceDetailsContainer = JvmResourceDetailsContainer.getInstance();
    }


    // special getter
    public JvmResourceDetails get(final int index) {
        return this.jvmResourceDetailsContainer.get(index);
    }


    // getter
    public long getTimeStamp() {
        return timeStamp;
    }
}
