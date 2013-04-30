package de.novensa.cs.performance.macadamia.statistics.technical;

import de.novensa.cs.performance.macadamia.statistics.descriptive.quantiles.FrequencyQuantileList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Radix sort for Java. Derived from: www.github.com/EroMod/RadixSort
 * https://github.com/EroMod/RadixSort/blob/master/RadixSort/src/radixsort/TheControl.java
 *
 * @author EroMod, Daniel Schulz
 */
public class RadixSort {

    private final static int DECIMAL_MAPPING_COUNT = 10;
    private final static int EVERY_MAPPINGS_SIZE_DENOMINATOR = 3;


    public static <N extends Number> List<N> sort(final List<N> value) {
        final int max = (Integer) FrequencyQuantileList.getMinAverageMaxValue(value).getValue2();
        return sortInternal(value, max);
    }


    public static <N extends Number> List<N> sort(final List<N> value, final int max) {
        /*if (isRadixSortApplicable(value)) {
            return sortInternal(value);
        } else {

        }*/
        return sortInternal(value, max);
    }

    /**
     * Sorts the given list with radix sort. This can be applied to lists of positive integer value only.
     *
     * @param value The list of unsorted values
     * @return The radix sorted value list
     */
    private static <N extends Number> List<N> sortInternal(final List<N> value, final Integer max) {

        // init
        @SuppressWarnings("unchecked")
        ArrayList<Integer> result = new ArrayList<Integer>((List<Integer>) value);
        final int size = value.size() / EVERY_MAPPINGS_SIZE_DENOMINATOR;
        final int smallSize = size / EVERY_MAPPINGS_SIZE_DENOMINATOR;

        ArrayList<ArrayList<Integer>> radixMapping = new ArrayList<ArrayList<Integer>>(size);
        for (int i = 0; i < DECIMAL_MAPPING_COUNT; i++) {
            radixMapping.add(new ArrayList<Integer>(smallSize));
        }

        Iterator<Integer> iterator;
        ArrayList<Integer> bySize;
        Integer power = 1;
        Integer number;
        Integer help;
        Integer pos;
        int i, j;


        // map
        while (power < max) {
            iterator = result.iterator();

            // first pass
            while (iterator.hasNext()) {
                number = iterator.next();
                if (number < power) {
                    radixMapping.get(0).add(number);
                } else {
                    help = number / power;
                    pos = help % DECIMAL_MAPPING_COUNT;
                    radixMapping.get(pos).add(number);
                }
            }

            // second pass
            result = new ArrayList<Integer>(result.size());
            for (i = 0; i < DECIMAL_MAPPING_COUNT; i++) {
                bySize = radixMapping.get(i);
                for (j = 0; j < bySize.size(); j++) {
                    result.add(bySize.get(j));
                }
                radixMapping.set(i, new ArrayList<Integer>(radixMapping.get(i).size()));
            }

            power *= DECIMAL_MAPPING_COUNT;
        }


        //noinspection unchecked
        return (List<N>) result;
    }
}
