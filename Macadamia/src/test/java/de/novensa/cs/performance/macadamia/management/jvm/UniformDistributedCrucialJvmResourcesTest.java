package de.novensa.cs.performance.macadamia.management.jvm;

import junit.framework.TestCase;

import java.util.concurrent.TimeUnit;

/**
 * Tests the entire management tool kit.
 *
 * @author Daniel Schulz
 */
public class UniformDistributedCrucialJvmResourcesTest extends TestCase {

    // constants
    private final long TO_MILLISECONDS = 1000;
    private final long initDelay = 1;
    private final long period = 3;


    public void testScheduleUpdatesTimes() throws Exception {
        // init
        UniformDistributedCrucialJvmResources resources =
                new UniformDistributedCrucialJvmResources(1, 3, TimeUnit.SECONDS);

        // tests
        // nothing in yet
        assertEquals(0, resources.getHistorySize());

        // slightly more time to make sure history was just added
        Thread.sleep(200);


        // init delay
        Thread.sleep(TO_MILLISECONDS);
        assertEquals(1, resources.getHistorySize());

        Thread.sleep(TO_MILLISECONDS);
        assertEquals(1, resources.getHistorySize());

        Thread.sleep(TO_MILLISECONDS);
        assertEquals(1, resources.getHistorySize());


        // first period
        Thread.sleep(TO_MILLISECONDS);
        assertEquals(2, resources.getHistorySize());

        // second period
        Thread.sleep(3 * TO_MILLISECONDS);
        assertEquals(3, resources.getHistorySize());

        // three period
        Thread.sleep(3 * TO_MILLISECONDS);
        assertEquals(4, resources.getHistorySize());
    }
}
