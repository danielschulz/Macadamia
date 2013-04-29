package de.novensa.cs.performance.macadamia.management.jvm.resources;

import junit.framework.TestCase;

import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: schulzda
 * Date: 28.04.13
 * Time: 17:41
 * To change this template use File | Settings | File Templates.
 */
public class JvmResourceDetailsHistoryContainerListMasterTestCase extends TestCase {

    // expected
    public static final List<String> ABCDEF_LIST = Arrays.asList(new String[]{"A", "B", "C", "D", "E", "F"});
    public static final List<String> ABCDEF_LAST_THREE_LIST = ABCDEF_LIST.subList(3, 6);


    // runtime constants
    public static final int ADD_RUNS = 1024;



    // business logic
    public static final JvmResourceDetailsHistoryContainerList<String> addElements(
            JvmResourceDetailsHistoryContainerList<String> strings) {

        strings.add("A");
        strings.add("B");
        strings.add("C");
        strings.add("D");
        strings.add("E");
        strings.add("F");

        return strings;
    }
}
