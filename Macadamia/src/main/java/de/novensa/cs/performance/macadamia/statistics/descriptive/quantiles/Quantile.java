package de.novensa.cs.performance.macadamia.statistics.descriptive.quantiles;

import java.util.Collection;

/**
 * Quantiles represent an n-quantile from keys and values. If there are no keys then keys and values are the same.
 *
 * @author Daniel Schulz
 */
public class Quantile<K,V> {

    // member fields
    private final int breakPointCount;



    // constructors
    private Quantile(final int breakPointCount) {
        this.breakPointCount = breakPointCount;
    }

    protected Quantile(final Collection<K> values, final int breakPointCount) {
        this(breakPointCount);
    }

    protected Quantile(final Collection<K> keys, final Collection<V> values, final int breakPointCount) {
        this(breakPointCount);
    }
}
