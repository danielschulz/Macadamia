package de.novensa.cs.performance.macadamia.management.jvm;

/**
 * This maps each <code>JvmResourceEnum</code> i to a value x_i in 0..1. The sum of all x_i there are is exactly one.
 * So all the values do sum up to one. The number of items is the number of enums in the mapping class. The amount of
 * enums is referenced to by n.
 * If uncertain the uniform distribution is taken where for each x_i the value is 1/n.
 *
 * @author Daniel Schulz
 */
public class JvmResourceCrucialDistribution {
}
