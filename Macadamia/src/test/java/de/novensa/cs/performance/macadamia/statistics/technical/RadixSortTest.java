package de.novensa.cs.performance.macadamia.statistics.technical;

import java.util.List;

/**
 * Tests the <code>RadixSort</code> class.
 *
 * @author Daniel Schulz
 */
public class RadixSortTest extends MasterSortTestCase {


    public void testRadixSorting() throws Exception {

        // init
        List<Integer> inputs = getUnsortedPositives();


        // tests
        assertFalse(isSorted(inputs));
        assertTrue(isSorted(getSorted()));


        final List<Integer> values = RadixSort.sort(inputs);
        assertEquals(inputs.size(), values.size());
        assertTrue(valuesAreTheSameButOutOfOrder(inputs, values));
        assertTrue(equalContentsInBothLists(getSortedPositives(), values));

        assertTrue(isSorted(values));
    }
}
