package de.novensa.cs.performance.macadamia.statistics.descriptive.quantiles;

import de.novensa.cs.performance.macadamia.statistics.technical.ConcreteNumber;
import org.javatuples.Triplet;

import java.util.Collection;

/**
 * Quantiles represent an n-quantile from keys and values. If there are no keys then keys and values are the same.
 *
 * @author Daniel Schulz
 */
public class Quantiles<K,V extends ConcreteNumber> {

    // member fields
    private final int breakPointCount;
    private /*final*/ Triplet<V, Double, V> minAverageMax;
    private /*final*/ V median;
    private final Collection<K> keys;
    private final Collection<V> values;


    // constructor
    protected Quantiles(final Collection<K> keys, final Collection<V> values, final int breakPointCount) {
        this.breakPointCount = breakPointCount;
        this.keys = keys;
        this.values = values;

        // get average, min and max
        this.minAverageMax = getMinAverageMaxValue(values);

        // sort values

        // get quantiles

        // get median
    }


    // technical logic
    public static <V extends ConcreteNumber> Triplet<V, Double, V> getMinAverageMaxValue(final Collection<V> values) {
        if (null == values || 0 == values.size()) {
            return null;
        }

        //noinspection unchecked,SuspiciousToArrayCall
        final V[] vs = (V[]) values.toArray(new ConcreteNumber[values.size()]);
        V min = vs[0];
        V max = vs[0];

        // average
        Double average = 0.0;

        // determine smallest and biggest
        for (V item : vs) {
            average += item.doubleValue();
            if (0 > ConcreteNumber.compareTo(item, min)) {
                min = item;
            } else if (0 < ConcreteNumber.compareTo(item, max)) {
                max = item;
            }
        }

        average /= vs.length;

        return new Triplet<V, Double, V>(min, average, max);
    }

    // getter / setter
    public int getBreakPointCount() {
        return breakPointCount;
    }

    public Triplet<V, Double, V> getMinAverageMax() {
        return minAverageMax;
    }

    public V getMin() {
        return minAverageMax.getValue0();
    }

    public Double getAverage() {
        return minAverageMax.getValue1();
    }

    public V getMax() {
        return minAverageMax.getValue2();
    }

    public V getMedian() {
        return median;
    }

    public Collection<K> getKeys() {
        return keys;
    }

    public Collection<V> getValues() {
        return values;
    }
}
