package de.novensa.cs.performance.macadamia.accessors;

import org.junit.Test;

import static de.novensa.cs.performance.macadamia.util.strategic.ClassCastPrediction.*;
import static de.novensa.cs.performance.macadamia.util.Constants.OBJECT;
import static de.novensa.cs.performance.macadamia.util.Constants.STRING;
import static org.junit.Assert.assertEquals;

/**
 * The test case for the auto boxing mapping.
 *
 * @author Daniel Schulz
 */
public class AutoBoxingMappingTest extends AutoBoxingTestObjects {

    @Test
    public void testAutoBoxingMappings() {

        assertEquals(POSSIBLE, sharedClassCache.isCastingPossible(STRING, STRING));
        assertEquals(POSSIBLE, sharedClassCache.isCastingPossible(STRING, OBJECT));
        assertEquals(POSSIBLE, sharedClassCache.isCastingPossible(OBJECT, OBJECT));
        assertEquals(CANNOT_BE_TOLD, sharedClassCache.isCastingPossible(OBJECT, STRING));

        assertEquals(LIKELY_POSSIBLE, sharedClassCache.isCastingPossible(INST_INTEGER, PRIM_INT));
        assertEquals(LIKELY_POSSIBLE, sharedClassCache.isCastingPossible(PRIM_INT, INST_INTEGER));
        assertEquals(LIKELY_POSSIBLE, sharedClassCache.isCastingPossible(INST_FLOAT, PRIM_FLOAT));
        assertEquals(LIKELY_POSSIBLE, sharedClassCache.isCastingPossible(PRIM_FLOAT, INST_FLOAT));

        assertEquals(POSSIBLE, sharedClassCache.isCastingPossible(INST_FLOAT, OBJECT));
        assertEquals(POSSIBLE, sharedClassCache.isCastingPossible(INST_INTEGER, OBJECT));
        assertEquals(POSSIBLE, sharedClassCache.isCastingPossible(PRIM_FLOAT, OBJECT));
        assertEquals(POSSIBLE, sharedClassCache.isCastingPossible(PRIM_INT, OBJECT));

        assertEquals(POSSIBLE, sharedClassCache.isCastingPossible(INST_BOOLEAN, PRIM_BOOLEAN));
        assertEquals(POSSIBLE, sharedClassCache.isCastingPossible(PRIM_BOOLEAN, INST_BOOLEAN));

        assertEquals(POSSIBLE, sharedClassCache.isCastingPossible(INST_BOOLEAN, INST_BOOLEAN));
        assertEquals(POSSIBLE, sharedClassCache.isCastingPossible(PRIM_BOOLEAN, PRIM_BOOLEAN));

        assertEquals(LIKELY_POSSIBLE, sharedClassCache.isCastingPossible(INST_INTEGER, PRIM_FLOAT));
        assertEquals(LIKELY_POSSIBLE, sharedClassCache.isCastingPossible(INST_FLOAT, PRIM_INT));


        assertEquals(IMPOSSIBLE, sharedClassCache.isCastingPossible(INST_BOOLEAN, PRIM_INT));
        assertEquals(IMPOSSIBLE, sharedClassCache.isCastingPossible(INST_BOOLEAN, INST_INTEGER));
        assertEquals(IMPOSSIBLE, sharedClassCache.isCastingPossible(PRIM_BOOLEAN, PRIM_INT));
        assertEquals(IMPOSSIBLE, sharedClassCache.isCastingPossible(PRIM_BOOLEAN, INST_INTEGER));

        assertEquals(IMPOSSIBLE, sharedClassCache.isCastingPossible(PRIM_INT, INST_BOOLEAN));
        assertEquals(IMPOSSIBLE, sharedClassCache.isCastingPossible(INST_INTEGER, INST_BOOLEAN));
        assertEquals(IMPOSSIBLE, sharedClassCache.isCastingPossible(PRIM_INT, PRIM_BOOLEAN));
        assertEquals(IMPOSSIBLE, sharedClassCache.isCastingPossible(INST_INTEGER, PRIM_BOOLEAN));
    }
}
