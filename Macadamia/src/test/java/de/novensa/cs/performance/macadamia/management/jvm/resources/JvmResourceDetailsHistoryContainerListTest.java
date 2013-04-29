package de.novensa.cs.performance.macadamia.management.jvm.resources;

import de.novensa.cs.performance.macadamia.testUtils.AssertLists;
import org.testng.annotations.Test;

/**
 * Tests the self implemented Ring Buffer based on an <code>ArrayList</code>.
 *
 * @author Daniel Schulz
 */
public class JvmResourceDetailsHistoryContainerListTest extends JvmResourceDetailsHistoryContainerListMasterTestCase {

    @Test
    public void testAddUnlimited() throws Exception {
        // init
        JvmResourceDetailsHistoryContainerList<String> strings = new JvmResourceDetailsHistoryContainerList<String>();
        strings = addElements(strings);

        // test
        AssertLists.assertListEquivalence(ABCDEF_LIST, strings);

        for (int i = 0; i < ADD_RUNS; i++) {
            strings.addAll(ABCDEF_LIST);

            assertEquals((2 + i) * ABCDEF_LIST.size(), strings.size());
        }
    }

    @Test
    public void testAddLimited() throws Exception {
        // init
        JvmResourceDetailsHistoryContainerList<String> strings = new JvmResourceDetailsHistoryContainerList<String>(3);
        strings = addElements(strings);

        // test
        AssertLists.assertListEquivalence(ABCDEF_LAST_THREE_LIST, strings);

        for (int i = 0; i < ADD_RUNS; i++) {
            strings.addAll(ABCDEF_LIST);
            assertEquals(ABCDEF_LAST_THREE_LIST.size(), strings.size());
            AssertLists.assertListEquivalence(ABCDEF_LAST_THREE_LIST, strings);

            strings.addAll(ABCDEF_LAST_THREE_LIST);
            assertEquals(ABCDEF_LAST_THREE_LIST.size(), strings.size());
            AssertLists.assertListEquivalence(ABCDEF_LAST_THREE_LIST, strings);
        }
    }

    @Test
    public void testAllInConstructor() throws Exception {
        // init
        JvmResourceDetailsHistoryContainerList<String> strings =
                new JvmResourceDetailsHistoryContainerList<String>(ABCDEF_LIST);

        // test
        AssertLists.assertListEquivalence(ABCDEF_LIST, strings);
    }


    @Test
    public void testAddAll() throws Exception {
        // init
        JvmResourceDetailsHistoryContainerList<String> strings = new JvmResourceDetailsHistoryContainerList<String>();
        strings.addAll(ABCDEF_LIST);

        // test
        AssertLists.assertListEquivalence(ABCDEF_LIST, strings);
    }

    @Test
    public void testRemove() throws Exception {

    }

    @Test
    public void testGetCircularBufferSize() throws Exception {

    }
}
