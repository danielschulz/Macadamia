package de.novensa.cs.performance.macadamia;

import org.javatuples.Pair;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The existing-within-indexes-tests are placed here.
 *
 * @author Daniel Schulz
 */
public class ChangeTests {

    @Test
    @Before
    public void testBefore() throws Exception {
    }

    @Test
    public void testName() throws Exception {
        Pair<String, Boolean> willChange = new Pair<String, Boolean>("willChange", Boolean.FALSE);

        willChange.setAt1(Boolean.TRUE);
    }

    @Test
    @After
    public void testAfter() throws Exception {
    }
}
