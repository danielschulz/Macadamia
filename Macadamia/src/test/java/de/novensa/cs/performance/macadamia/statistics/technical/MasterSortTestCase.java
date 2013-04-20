package de.novensa.cs.performance.macadamia.statistics.technical;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Delivers sorting instances to test with.
 *
 * @author Daniel Schulz
 */
public abstract class MasterSortTestCase extends TestCase {

    private static List<Integer> UNSORTED = new ArrayList<Integer>(32);
    private static List<Integer> SORTED = new ArrayList<Integer>(UNSORTED.size());
    static {
        // unsorted
        UNSORTED.add(32);
        UNSORTED.add(-5);
        UNSORTED.add(1122);

        UNSORTED.add(-12);
        UNSORTED.add(44);
        UNSORTED.add(8756);

        UNSORTED.add(-32);
        UNSORTED.add(102);
        UNSORTED.add(42);

        UNSORTED.add(5645613);
        UNSORTED.add(-56532328);
        UNSORTED.add(0);

        UNSORTED.add(42);
        UNSORTED.add(-102);
        UNSORTED.add(56532328);


        // sorted
        SORTED.addAll(UNSORTED);
    }

    // technical logic
    public static final <V extends Comparable> boolean isSorted(final List<V> values) {

        int i = -1;
        for (V v : values) {
            if (0 < v.compareTo(values.get(++i))) {
                return false;
            }
        }

        return true;
    }


    // getters
    public static final List<Integer> getUnsorted() {
        return UNSORTED;
    }

    public static final List<Integer> getSorted() {
        Integer[] sorted = UNSORTED.toArray(new Integer[UNSORTED.size()]);
        Arrays.sort(sorted);
        return Arrays.asList(sorted);
    }


    // default test case
    public void testNothing() throws Exception {
    }
}
