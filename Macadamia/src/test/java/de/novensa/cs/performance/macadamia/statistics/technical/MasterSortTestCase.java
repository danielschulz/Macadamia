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
    public static List<Integer> getUnsorted() {
        return UNSORTED;
    }

    public static List<Integer> getSorted() {
        Integer[] sorted = UNSORTED.toArray(new Integer[UNSORTED.size()]);
        Arrays.sort(sorted);
        return Arrays.asList(sorted);
    }

    public static List<Integer> getUnsortedPositives() {
        return UNSORTED_POSITIVES;
    }

    public static List<Integer> getSortedPositives() {
        Integer[] sorted = UNSORTED_POSITIVES.toArray(new Integer[UNSORTED_POSITIVES.size()]);
        Arrays.sort(sorted);
        return Arrays.asList(sorted);
    }


    /**
     * Checks whether both lists do have the same elements. The lists are not allowed to point to the same memory
     * reference or have differing sizes.
     *
     * @param a The expected list
     * @param b The target list to find the origin elements in
     * @param <V> The kind of values in both lists
     * @return true iff all elements of <code>a</code> can be found in list <code>b</code>
     */
    public static <V extends Number> boolean valuesAreTheSameButOutOfOrder(final List<V> a, final List<V> b) {

        assert null != a && null != b;
        assert a != b;
        assert a.size() == b.size();

        for (V item : a) {
            if (!b.contains(item)) {
                return false;
            }
        }

        return true;
    }


    /**
     * Checks the list with testing it´s orderings. First it makes sure the lists are the same length, not null, and
     * do not point to the same data field. The identity check is made with <code>equals</code> method derived from
     * <code>java.lang.Object</code> or the class itself.
     *
     * @param a The expected list
     * @param b The list to checks it´s same order
     * @param <V> The kind of values in both lists
     * @return true iff both are identical in the elements contained
     */
    public static <V> boolean equalContentsInBothLists(final List<V> a, final List<V> b) {

        assert null != a && null != b;
        assert a != b;
        assert a.size() == b.size();

        for (V item : a) {
            if (!a.equals(b)) {
                return false;
            }
        }

        return true;
    }



    // default test case
    public void testNothing() throws Exception {
    }
}
