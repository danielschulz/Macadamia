package de.novensa.cs.performance.macadamia.statistics.descriptive.quantiles;

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

    public static final List<Long> VALUE_LIST = new ArrayList<Long>(32);
    static {
        VALUE_LIST.add(10L);
        VALUE_LIST.add(MAX);
        VALUE_LIST.add(0L);

        VALUE_LIST.add(-10L);
        VALUE_LIST.add(500L);
        VALUE_LIST.add(750L);

        VALUE_LIST.add(0L);
        VALUE_LIST.add(MIN);
        VALUE_LIST.add(10L);

        VALUE_LIST.add(100L);
        VALUE_LIST.add(50L);
        VALUE_LIST.add(25L);
        VALUE_LIST.add(15L);
    }
}
