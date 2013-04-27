package de.novensa.cs.performance.macadamia.management.jvm.resources.enums;

/**
 * This enum lists all the resources we consider when looking at the JVM management information.
 *
 * @author Daniel Schulz
 */
public enum GenericResourceEnum {
    Memory, CpuTime, Network, DiskReads, DiskWrites, DatabaseReads, DatabaseWrites,
    MessageServices, UserTime
}
