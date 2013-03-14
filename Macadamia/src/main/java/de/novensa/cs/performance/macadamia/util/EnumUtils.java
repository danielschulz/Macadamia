package de.novensa.cs.performance.macadamia.util;

import de.novensa.cs.performance.macadamia.accessors.ClassCastPrediction;

/**
 * Helps dealing with special enumerations from that productive code.
 *
 * @author Daniel Schulz
 */
@SuppressWarnings("UnusedDeclaration")
public class EnumUtils {

    public static ClassCastPrediction getPessimisticClassCastPrediction(ClassCastPrediction a, ClassCastPrediction b) {
        return a.ordinal() > b.ordinal() ? b : a;
    }

    public static ClassCastPrediction getOptimisticClassCastPrediction(ClassCastPrediction a, ClassCastPrediction b) {
        return a.ordinal() > b.ordinal() ? a : b;
    }

    public static int getAisBetterThanB(ClassCastPrediction a, ClassCastPrediction b) {
        return a.ordinal() - b.ordinal();
    }
}
