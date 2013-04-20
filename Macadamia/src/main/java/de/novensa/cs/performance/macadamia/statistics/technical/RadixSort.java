package de.novensa.cs.performance.macadamia.statistics.technical;

import de.novensa.cs.performance.macadamia.statistics.descriptive.quantiles.Quantiles;

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

    public static <V extends Integer /*Number*/> List<Integer> sortRadix(List<Integer> numbers) {

        // init
        ArrayList<Integer> result = new ArrayList<Integer>(numbers);
        final int maxValue = Quantiles.getMinAverageMaxValue(numbers).getValue2();

        ArrayList<ArrayList<Integer>> radixMapping = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < DECIMAL_MAPPING_COUNT; i++) {
            radixMapping.add(new ArrayList<Integer>(numbers.size() / EVERY_MAPPINGS_SIZE_DENOMINATOR));
        }

        Iterator<Integer> iterator;
        ArrayList<Integer> bySize;
        Integer power = 1;
        Integer number;
        Integer help;
        Integer pos;
        int i, j;


        // map
        while (power < maxValue) {
            iterator = result.iterator();

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

            result.clear();
            for (i = 0; i < DECIMAL_MAPPING_COUNT; i++) {
                bySize = radixMapping.get(i);
                for (j = 0; j < bySize.size(); j++) {
                    result.add(bySize.get(j));
                }
                radixMapping.get(i).clear();
            }

            power *= DECIMAL_MAPPING_COUNT;
        }


        assert result.size() == 15;

        return result;
    }
}
