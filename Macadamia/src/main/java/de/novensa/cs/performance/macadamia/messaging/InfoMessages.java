package de.novensa.cs.performance.macadamia.messaging;

import de.novensa.cs.performance.macadamia.util.MathUtils;

/**
 * Central store for informational messages of all kinds. They're internally separated by sectioning via comments.
 *
 * @author Daniel Schulz
 */
public class InfoMessages {

    private static final int ROUND_TO_PLACES = 1;

    // Self-explanatory Constants to take right away
    private static final String PERFORMANCE_METRICS_OUTPUT_CLASS_TO_CLASS_TO_PREDICTION_CACHE_USAGE =
            "About %s percent of the requests were answered from the cast-Class-to-Class cache. \n\n" +
            "In total there were %s requests. %s from that were cached answered and %s had to be looked up initially.";

    // Methods to format a little more complex messages
    public static String getPerformanceMetricsOutputClassToClassToPredictionCacheUsage
    (final long answeredFromCache, final long calculated) {

        return String.format(PERFORMANCE_METRICS_OUTPUT_CLASS_TO_CLASS_TO_PREDICTION_CACHE_USAGE,
                MathUtils.getRatioFromDistinct(answeredFromCache, calculated, ROUND_TO_PLACES),
                answeredFromCache + calculated, answeredFromCache, calculated);
    }
}
