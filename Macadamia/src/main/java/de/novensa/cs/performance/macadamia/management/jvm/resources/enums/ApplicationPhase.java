package de.novensa.cs.performance.macadamia.management.jvm.resources.enums;

/**
 * This describes the application´s phase: init, running, and shutdown. This will be used to predict memory
 * leaks.
 *
 * @author Daniel Schulz
 */
public enum ApplicationPhase {
    INIT, RUNNING, SHUTDOWN
}
