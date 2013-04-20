package de.novensa.cs.performance.macadamia.statistics.descriptive.quantiles;

import de.novensa.cs.performance.macadamia.statistics.technical.ConcreteNumber;
import org.javatuples.Pair;

import java.util.Collection;

/**
 * Quantiles represent an n-quantile from keys and values. If there are no keys then keys and values are the same.
 *
 * @author Daniel Schulz
 */
public class Quantiles<K,V extends ConcreteNumber> {

    // member fields
    private final int breakPointCount;
    private /*final*/ Pair<V, V> minMaxValue;
    private /*final*/ V median;
    private /*final*/ V average;


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
    public static <V extends ConcreteNumber> Pair<V, V> getMinMaxValue(final Collection<V> values) {
        if (null == values || 0 == values.size()) {
            return null;
        }

        //noinspection unchecked,SuspiciousToArrayCall
        final V[] vs = (V[]) values.toArray(new ConcreteNumber[values.size()]);
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

        return new Pair<V, V>(min, max);
    }
}
