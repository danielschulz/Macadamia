package de.novensa.cs.performance.macadamia.statistics.descriptive.quantiles;

import org.javatuples.Pair;

import java.util.Collection;

/**
 * Quantiles represent an n-quantile from keys and values. If there are no keys then keys and values are the same.
 *
 * @author Daniel Schulz
 */
public class Quantiles<K,V extends Long> {

    // member fields
    private final int breakPointCount;
    private /*final*/ Pair<Long, Long> minMaxValue;
    private /*final*/ long median;
    private /*final*/ long average;


    // constructors
    private Quantiles(final int breakPointCount) {
        this.breakPointCount = breakPointCount;
    }

    protected Quantiles(final Collection<K> values, final int breakPointCount) {
        this(breakPointCount);
    }

    protected Quantiles(final Collection<K> keys, final Collection<V> values, final int breakPointCount) {
        this(breakPointCount);
    }


    // technical logic
    public static <V extends Long> Pair<V, V> getMinMaxValue(final Collection<V> values) {
        if (null == values || 0 == values.size()) {
            return null;
        }

        final V[] vs = (V[]) values.toArray(new Long[values.size()]);
        V min = vs[0];
        V max = vs[0];

        // determine smallest and biggest
        for (V item : vs) {
            if (0 > item.compareTo(min)) {
                min = item;
            } else if (0 < item.compareTo(max)) {
                max = item;
            }
        }

        return new Pair(min, max);
    }
}
