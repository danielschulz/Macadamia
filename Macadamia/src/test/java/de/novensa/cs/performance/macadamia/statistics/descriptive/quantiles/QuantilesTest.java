package de.novensa.cs.performance.macadamia.statistics.descriptive.quantiles;

import de.novensa.cs.performance.macadamia.statistics.technical.ConcreteNumber;
import org.javatuples.Pair;
import org.junit.Test;

/**
 * Tests the quantiles with <code>QuantilesMasterTestCase</code> values.
 *
 * @author Daniel Schulz
 */
public class QuantilesTest extends QuantilesMasterTestCase {

    @Test
    public void testMinMaxValues() throws Exception {
        // init
        Pair<ConcreteNumber<Long>, ConcreteNumber<Long>> minMax = Quantiles.getMinMaxValue(VALUE_LIST);

        Long min = minMax.getValue0().longValue();
        Long max = minMax.getValue1().longValue();


        // test
        assertEquals(MIN, min);
        assertEquals(MAX, max);
    }
}
