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
    private static List<Integer> UNSORTED_POSITIVES = new ArrayList<Integer>(32);
    static {
        UNSORTED.addAll(Arrays.asList(
                32, -5, 1122, -12, 44, 8756, -32, 102, 42, 56613, -5658, 0, 42, -102, 56528));
        UNSORTED_POSITIVES.addAll(Arrays.asList(
                32, 5, 1122, 12, 44, 8756, 32, 102, 42, 56613, 5658, 0, 42, 102, 56528));
    }

    // technical logic
    public static final boolean isSorted(final List<Integer> values) {

        int a,b;
        for (int i = 0; i < values.size() - 1; i++) {

            a = values.get(i);
            b = values.get(i + 1);
            if (a > b){
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

    public static final List<Integer> getUnsortedPositives() {
        return UNSORTED_POSITIVES;
    }

    public static final List<Integer> getSortedPositives() {
        Integer[] sorted = UNSORTED_POSITIVES.toArray(new Integer[UNSORTED_POSITIVES.size()]);
        Arrays.sort(sorted);
        return Arrays.asList(sorted);
    }


    public static <V extends Number> boolean valuesAreTheSameButOutOfOrder(final List<V> a, final List<V> b) {

        for (V item : a) {
            if (!b.contains(item)) {
                return false;
            }
        }

        return true;
    }




    // default test case
    public void testNothing() throws Exception {
    }
}
