package de.novensa.cs.performance.macadamia.accessors;

/**
 * Use Java's inheritance techniques to make an prediction about the casting outcomes.
 *
 * @author Daniel Schulz
 */
public abstract class AdvancedJavaCastingRules {

    public static ClassCastPrediction isCastingPossible(Class from, Class to) {

        // is the target class a more general class?
        Class[] classes = from.getClasses();

        // is the target class an implementing interface?
        Class[] interfaces = from.getInterfaces();


        return null;
    }
}
