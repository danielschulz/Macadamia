package de.novensa.cs.performance.macadamia.management.jvm.util;

/**
 * This enum lists all the resources we consider when looking at the JVM management information.
 *
 * @author Daniel Schulz
 */
public enum JvmResourceEnum {
    Memory, CpuTime, Network, DiskReads, DiskWrites, UserTime
}
