package de.novensa.cs.performance.macadamia.statistics.descriptive.quantiles;

import de.novensa.cs.performance.macadamia.statistics.technical.ConcreteNumber;
import org.javatuples.Triplet;
import org.junit.Test;

/**
 * Tests the quantiles with <code>QuantilesMasterTestCase</code> values.
 *
 * @author Daniel Schulz
 */
public class FrequencyQuantileListTest extends QuantilesMasterTestCase {

    @SuppressWarnings("JUnit4AnnotatedMethodInJUnit3TestCase")
    @Test
    public void testMinMaxValues() throws Exception {
        // init
        Triplet<ConcreteNumber<Long>, Double, ConcreteNumber<Long>> minAverageMaxValue =
                FrequencyQuantileList.getMinAverageMaxValue(VALUE_LIST);

        Long min = minAverageMaxValue.getValue0().longValue();
        Long max = minAverageMaxValue.getValue2().longValue();
        Double average = minAverageMaxValue.getValue1();


        // test
        assertEquals(MIN, min);
        assertEquals(MAX, max);
        assertEquals(AVERAGE, average);
    }
}
