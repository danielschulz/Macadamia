package de.novensa.cs.performance.macadamia.statistics.descriptive.quantiles;

import de.novensa.cs.performance.macadamia.statistics.technical.ConcreteNumber;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * Defines instances to test descriptive statistics test.
 *
 * @author Daniel Schulz
 */
public class QuantilesMasterTestCase extends TestCase {

    public static final Long MIN = -10L;
    public static final Long MAX = 1000L;

    public static final List<ConcreteNumber<Long>> VALUE_LIST = new ArrayList<ConcreteNumber<Long>>(32);
    static {
        add(VALUE_LIST, 10L);
        add(VALUE_LIST, 10L);
        add(VALUE_LIST, MAX);
        add(VALUE_LIST, 0L);

        add(VALUE_LIST, -10L);
        add(VALUE_LIST, 500L);
        add(VALUE_LIST, 750L);

        add(VALUE_LIST, 0L);
        add(VALUE_LIST, MIN);
        add(VALUE_LIST, 10L);

        add(VALUE_LIST, 100L);
        add(VALUE_LIST, 50L);
        add(VALUE_LIST, 25L);
        add(VALUE_LIST, 15L);
    }

    private static <N extends Number> void add(final List<ConcreteNumber<N>> values, N number) {
        values.add(new ConcreteNumber<N>(number));
    }

    // default test case
    public void testNothing() throws Exception {
    }
}
