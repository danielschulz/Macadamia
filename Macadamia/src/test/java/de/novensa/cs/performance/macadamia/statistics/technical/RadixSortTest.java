package de.novensa.cs.performance.macadamia.statistics.technical;

/**
 * Tests the <code>RadixSort</code> class.
 *
 * @author Daniel Schulz
 */
public class RadixSortTest extends MasterSortTestCase {


    public void testRadixSorting() throws Exception {

        // tests
        assertFalse(isSorted(getUnsorted()));
        assertTrue(isSorted(getSorted()));
        assertTrue(isSorted(RadixSort.sortRadix(getUnsortedPositives())));
    }
}
