package de.novensa.cs.performance.macadamia.management.jvm.resources;

import junit.framework.TestCase;
import org.testng.annotations.Test;

/**
 * Tests the self implemented Ring Buffer based on an <code>ArrayList</code>.
 *
 * @author Daniel Schulz
 */
public class JvmResourceDetailsHistoryContainerListTest extends TestCase {

    @Test
    public void testAdd() throws Exception {
        JvmResourceDetailsHistoryContainerList<String> strings = new JvmResourceDetailsHistoryContainerList<String>();
        strings.add("A");
        strings.add("B");
        strings.add("C");
        strings.add("D");
        strings.add("E");
        strings.add("F");


    }

    @Test
    public void testAddAll() throws Exception {

    }

    @Test
    public void testRemove() throws Exception {

    }

    @Test
    public void testGetCircularBufferSize() throws Exception {

    }
}
