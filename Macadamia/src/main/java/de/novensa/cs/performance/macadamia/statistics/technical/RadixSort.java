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

    public static <V extends Integer /*Number*/> List<Integer> sortRadix(List<Integer> numbers) {

        ArrayList<Integer> localNumbers = new ArrayList<Integer>(numbers.size());
        final int max = Quantiles.getMinAverageMaxValue(numbers).getValue2();

        ArrayList<ArrayList<Integer>> radixMapping = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < DECIMAL_MAPPING_COUNT; i++) {
            ArrayList<Integer> myList = new ArrayList<Integer>();
            radixMapping.add(myList);
        }

        Integer power = 1;
        Iterator<Integer> iterator;

        while (power < max) {
            iterator = localNumbers.iterator();
            while (iterator.hasNext()) {
                Integer nr = (Integer) iterator.next();
                if (nr < power) {
                    radixMapping.get(0).add(nr);
                } else {
                    Integer help = nr / power;
                    Integer pos = help % DECIMAL_MAPPING_COUNT;
                    radixMapping.get(pos).add(nr);
                }
            }

            localNumbers.clear();
            for (int i = 0; i < DECIMAL_MAPPING_COUNT; i++) {
                ArrayList<Integer> myList = radixMapping.get(i);
                for (int j = 0; j < myList.size(); j++) {
                    localNumbers.add(myList.get(j));
                }
                radixMapping.get(i).clear();
            }

            power = DECIMAL_MAPPING_COUNT * power;
        }


        numbers.clear();
        for (Integer nr : localNumbers) {
            numbers.add(nr);
        }

        return numbers;
    }
}
