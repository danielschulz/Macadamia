package de.novensa.cs.performance.macadamia.statistics.descriptive.quantiles;

import org.javatuples.Pair;
import org.junit.Test;

/**
 *
 *
 * @author Daniel Schulz
 */
public class QuantilesTest extends QuantilesMasterTestCase {

    @Test
    public void testMinMaxValues() throws Exception {
        // init
        Pair<Long, Long> minMax = Quantiles.getMinMaxValue(VALUE_LIST);

        // test
        Long min = minMax.getValue0();
        Long max = minMax.getValue1();

        assertEquals(MIN, min);
        assertEquals(MAX, max);
    }
}
