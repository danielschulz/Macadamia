package de.novensa.cs.performance.macadamia.accessors.caches;

import static de.novensa.cs.performance.macadamia.messaging.InfoMessages.getPerformanceMetricsOutputClassToClassToPredictionCacheUsage;

/**
 * Defines the Cache´s basis by providing performance metrics.
 */
public abstract class AbstractPerfomanceMeteredCache {

    long requestsAnsweredFromCache = 0L;
    long requestsHadToBeCalculated = 0L;

    final int numberOfEntriesToExpect;

    public final String getPerformanceMetrics() {
        return getPerformanceMetricsOutputClassToClassToPredictionCacheUsage(
                requestsAnsweredFromCache, requestsHadToBeCalculated);
    }

    // basic beam members

    public AbstractPerfomanceMeteredCache(int numberOfEntriesToExpect) {
        this.numberOfEntriesToExpect = numberOfEntriesToExpect;
    }
}
