package de.novensa.cs.performance.macadamia.management.jvm.util;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryUsage;
import java.lang.management.ThreadInfo;

/**
 * Get the detailed versioned information about the JVM resources.
 *
 * @author Daniel Schulz
 */
public class JvmResourceDetails {

    private final long timeStamp;
    private final MemoryUsage heapUsage;
    private final MemoryUsage nonHeapUsage;
    private final ThreadInfo[] threadInformation;


    // constructor
    public JvmResourceDetails() {
        this.timeStamp = System.nanoTime();

        this.heapUsage = ManagementFactory.getMemoryMXBean().getHeapMemoryUsage();
        this.nonHeapUsage = ManagementFactory.getMemoryMXBean().getNonHeapMemoryUsage();
        this.threadInformation =
                ManagementFactory.getThreadMXBean().getThreadInfo(ManagementFactory.getThreadMXBean().getAllThreadIds());
    }


    // getter
    public long getTimeStamp() {
        return timeStamp;
    }

    public MemoryUsage getHeapUsage() {
        return heapUsage;
    }

    public MemoryUsage getNonHeapUsage() {
        return nonHeapUsage;
    }

    public ThreadInfo[] getThreadInformation() {
        return threadInformation;
    }
}
