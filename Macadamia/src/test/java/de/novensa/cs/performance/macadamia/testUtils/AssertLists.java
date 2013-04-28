package de.novensa.cs.performance.macadamia.testUtils;

import javax.annotation.Nullable;
import java.util.Iterator;
import java.util.List;

/**
 * Can test the equivalence of lists.
 *
 * @author Daniel Schulz
 */
public class AssertLists {

    public static boolean assertListEquivalence(final List expected, final List result) {
        String testRes = assertListEquivalenceInternal(expected, result);
        if (null != testRes) {
            throw new AssertionError(testRes);
        }

        return true;
    }


    @Nullable
    private static String assertListEquivalenceInternal(final List expected, final List result) {

        if ((null == expected && null == result) || expected == result) {
            return null;

        } else if ((null == expected && null != result ) || (null != expected && null == result)) {
            return null == expected ?
                    TestUtilErrorMessages.LIST_EXPECTED_LIST_IS_NULL :
                    TestUtilErrorMessages.LIST_RESULT_LIST_IS_NULL;

        } else if (expected.size() != result.size()) {
            return String.format(TestUtilErrorMessages.LIST_SIZES_DO_NOT_MATCH, expected.size(), result.size());

        } else {

            Iterator expIter = expected.iterator();
            Iterator resIter = result.iterator();
            int index = 0;

            while (expIter.hasNext()) {
                Object exp = expIter.next();
                Object res = resIter.next();
                if (!exp.equals(res)) {
                    return String.format(TestUtilErrorMessages.COMPARING_ITEM_MISMATCH, index, exp, res);
                }
                index++;
            }

            return null;
        }
    }
}
