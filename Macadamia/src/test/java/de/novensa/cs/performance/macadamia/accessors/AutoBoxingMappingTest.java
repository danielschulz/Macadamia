package de.novensa.cs.performance.macadamia.accessors;

import org.junit.Assert;
import org.junit.Test;

import static de.novensa.cs.performance.macadamia.util.ClassCastPrediction.*;
import static de.novensa.cs.performance.macadamia.util.Constants.OBJECT;
import static de.novensa.cs.performance.macadamia.util.Constants.STRING;

/**
 * The test case for the auto boxing mapping.
 *
 * @author Daniel Schulz
 */
public class AutoBoxingMappingTest extends AutoBoxingTestObjects {

    @Test
    public void testAutoBoxingMappings() {

        Assert.assertEquals(POSSIBLE, sharedClassCache.isCastingPossible(STRING, STRING));
        Assert.assertEquals(POSSIBLE, sharedClassCache.isCastingPossible(STRING, OBJECT));
        Assert.assertEquals(POSSIBLE, sharedClassCache.isCastingPossible(OBJECT, OBJECT));
        Assert.assertEquals(CANNOT_BE_TOLD, sharedClassCache.isCastingPossible(OBJECT, STRING));

        Assert.assertEquals(LIKELY_POSSIBLE, sharedClassCache.isCastingPossible(INST_INTEGER, PRIM_INT));
        Assert.assertEquals(LIKELY_POSSIBLE, sharedClassCache.isCastingPossible(PRIM_INT, INST_INTEGER));
        Assert.assertEquals(LIKELY_POSSIBLE, sharedClassCache.isCastingPossible(INST_FLOAT, PRIM_FLOAT));
        Assert.assertEquals(LIKELY_POSSIBLE, sharedClassCache.isCastingPossible(PRIM_FLOAT, INST_FLOAT));

        Assert.assertEquals(POSSIBLE, sharedClassCache.isCastingPossible(INST_FLOAT, OBJECT));
        Assert.assertEquals(POSSIBLE, sharedClassCache.isCastingPossible(INST_INTEGER, OBJECT));
        Assert.assertEquals(POSSIBLE, sharedClassCache.isCastingPossible(PRIM_FLOAT, OBJECT));
        Assert.assertEquals(POSSIBLE, sharedClassCache.isCastingPossible(PRIM_INT, OBJECT));

        Assert.assertEquals(POSSIBLE, sharedClassCache.isCastingPossible(INST_BOOLEAN, PRIM_BOOLEAN));
        Assert.assertEquals(POSSIBLE, sharedClassCache.isCastingPossible(PRIM_BOOLEAN, INST_BOOLEAN));

        Assert.assertEquals(POSSIBLE, sharedClassCache.isCastingPossible(INST_BOOLEAN, INST_BOOLEAN));
        Assert.assertEquals(POSSIBLE, sharedClassCache.isCastingPossible(PRIM_BOOLEAN, PRIM_BOOLEAN));

        Assert.assertEquals(LIKELY_POSSIBLE, sharedClassCache.isCastingPossible(INST_INTEGER, PRIM_FLOAT));
        Assert.assertEquals(LIKELY_POSSIBLE, sharedClassCache.isCastingPossible(INST_FLOAT, PRIM_INT));


        Assert.assertEquals(IMPOSSIBLE, sharedClassCache.isCastingPossible(INST_BOOLEAN, PRIM_INT));
        Assert.assertEquals(IMPOSSIBLE, sharedClassCache.isCastingPossible(INST_BOOLEAN, INST_INTEGER));
        Assert.assertEquals(IMPOSSIBLE, sharedClassCache.isCastingPossible(PRIM_BOOLEAN, PRIM_INT));
        Assert.assertEquals(IMPOSSIBLE, sharedClassCache.isCastingPossible(PRIM_BOOLEAN, INST_INTEGER));
    }
}
