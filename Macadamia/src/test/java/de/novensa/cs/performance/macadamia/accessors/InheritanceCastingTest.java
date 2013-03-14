package de.novensa.cs.performance.macadamia.accessors;

import org.junit.Test;

import static de.novensa.cs.performance.macadamia.accessors.ClassCastPrediction.IMPOSSIBLE;
import static de.novensa.cs.performance.macadamia.accessors.ClassCastPrediction.POSSIBLE;
import static junit.framework.TestCase.assertEquals;

/**
 * Test Java´s advanced inheritances and interfaces.
 *
 * @author Daniel Schulz
 */
@SuppressWarnings("JUnit4AnnotatedMethodInJUnit3TestCase")
public class InheritanceCastingTest extends InheritanceTestObjects {

    @Test
    public void testInheritanceCastings() {
        // Homer
        assertEquals(POSSIBLE, sharedClassCache.isCastingPossible(HOMER, HOMER));
        assertEquals(IMPOSSIBLE, sharedClassCache.isCastingPossible(HOMER, MARGE));
        assertEquals(IMPOSSIBLE, sharedClassCache.isCastingPossible(HOMER, PETER));

        assertEquals(POSSIBLE, sharedClassCache.isCastingPossible(HOMER, AMERICAN));
        assertEquals(IMPOSSIBLE, sharedClassCache.isCastingPossible(HOMER, FRENCH));

        assertEquals(POSSIBLE, sharedClassCache.isCastingPossible(HOMER, HUMAN));
        assertEquals(POSSIBLE, sharedClassCache.isCastingPossible(HOMER, LIVING_THINGS));
        assertEquals(POSSIBLE, sharedClassCache.isCastingPossible(HOMER, SPONTANEOUS));

        assertEquals(IMPOSSIBLE, sharedClassCache.isCastingPossible(HOMER, FEMALE));
        assertEquals(POSSIBLE, sharedClassCache.isCastingPossible(HOMER, MALE));


        // Marge
        assertEquals(POSSIBLE, sharedClassCache.isCastingPossible(MARGE, HUMAN));
        assertEquals(POSSIBLE, sharedClassCache.isCastingPossible(MARGE, LIVING_THINGS));
        assertEquals(IMPOSSIBLE, sharedClassCache.isCastingPossible(MARGE, SPONTANEOUS));

        assertEquals(IMPOSSIBLE, sharedClassCache.isCastingPossible(MARGE, AMERICAN));
        assertEquals(POSSIBLE, sharedClassCache.isCastingPossible(MARGE, FRENCH));


        // Peter
        assertEquals(POSSIBLE, sharedClassCache.isCastingPossible(PETER, HUMAN));
        assertEquals(POSSIBLE, sharedClassCache.isCastingPossible(PETER, LIVING_THINGS));
        assertEquals(POSSIBLE, sharedClassCache.isCastingPossible(PETER, SPONTANEOUS));

        assertEquals(POSSIBLE, sharedClassCache.isCastingPossible(PETER, AMERICAN));
        assertEquals(IMPOSSIBLE, sharedClassCache.isCastingPossible(PETER, FRENCH));


        // tricky tasks
        assertEquals(POSSIBLE, sharedClassCache.isCastingPossible(MARGE, TOOL_BUILDER));
        assertEquals(POSSIBLE, sharedClassCache.isCastingPossible(MARGE, THINGS));
        assertEquals(POSSIBLE, sharedClassCache.isCastingPossible(MARGE, WORLD_ITEMS));
        assertEquals(POSSIBLE, sharedClassCache.isCastingPossible(HOMER, WORLD_ITEMS));
        assertEquals(POSSIBLE, sharedClassCache.isCastingPossible(PETER, WORLD_ITEMS));
    }
}
