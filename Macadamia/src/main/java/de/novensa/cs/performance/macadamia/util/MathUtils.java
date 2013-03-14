package de.novensa.cs.performance.macadamia.util;

/**
 * Does all kinds of generic calculations.
 *
 * @author Daniel Schulz
 */
@SuppressWarnings("UnusedDeclaration")
public class MathUtils {

    public static double getRatioFromDistinct(long first, long second) {
        return (first * 1.0) / second;
    }

    public static double getRatioFromDistinct(long first, long second, int placesToRound) {
        return roundByPlaces((first * 1.0) / second, placesToRound);
    }

    public static double roundByPlaces(double number, int places) {
        return Math.pow(10, places) * Math.round(number) * Math.pow(10, ((-1) * places));
    }
}
