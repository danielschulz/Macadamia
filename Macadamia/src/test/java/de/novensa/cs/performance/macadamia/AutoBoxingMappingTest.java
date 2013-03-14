package de.novensa.cs.performance.macadamia;

import de.novensa.cs.performance.macadamia.accessors.AutoBoxingMapping;
import org.junit.Assert;
import org.junit.Test;

import static de.novensa.cs.performance.macadamia.accessors.ClassCastPrediction.*;
import static de.novensa.cs.performance.macadamia.util.Constants.OBJECT;
import static de.novensa.cs.performance.macadamia.util.Constants.STRING;

/**
 * The test case for the auto boxing mapping.
 *
 * @author Daniel Schulz
 */
public class AutoBoxingMappingTest {

    private AutoBoxingMapping autoBoxingMapping = new AutoBoxingMapping();

    private static final Class INST_INTEGER = Integer.class;
    private static final Class PRIM_INT = int.class;
    private static final Class INST_FLOAT = Float.class;
    private static final Class PRIM_FLOAT = float.class;

    private static final Class INST_BOOLEAN = Boolean.class;
    private static final Class PRIM_BOOLEAN = boolean.class;


    @Test
    public void testAutoBoxingMappings() {

        Assert.assertEquals(POSSIBLE, autoBoxingMapping.isCastingPossible(STRING, STRING));
        Assert.assertEquals(POSSIBLE, autoBoxingMapping.isCastingPossible(STRING, OBJECT));
        Assert.assertEquals(POSSIBLE, autoBoxingMapping.isCastingPossible(OBJECT, OBJECT));
        Assert.assertEquals(CANNOT_BE_TOLD, autoBoxingMapping.isCastingPossible(OBJECT, STRING));

        Assert.assertEquals(LIKELY_POSSIBLE, autoBoxingMapping.isCastingPossible(INST_INTEGER, PRIM_INT));
        Assert.assertEquals(LIKELY_POSSIBLE, autoBoxingMapping.isCastingPossible(PRIM_INT, INST_INTEGER));
        Assert.assertEquals(LIKELY_POSSIBLE, autoBoxingMapping.isCastingPossible(INST_FLOAT, PRIM_FLOAT));
        Assert.assertEquals(LIKELY_POSSIBLE, autoBoxingMapping.isCastingPossible(PRIM_FLOAT, INST_FLOAT));

        Assert.assertEquals(POSSIBLE, autoBoxingMapping.isCastingPossible(INST_FLOAT, OBJECT));
        Assert.assertEquals(POSSIBLE, autoBoxingMapping.isCastingPossible(INST_INTEGER, OBJECT));
        Assert.assertEquals(POSSIBLE, autoBoxingMapping.isCastingPossible(PRIM_FLOAT, OBJECT));
        Assert.assertEquals(POSSIBLE, autoBoxingMapping.isCastingPossible(PRIM_INT, OBJECT));

        Assert.assertEquals(POSSIBLE, autoBoxingMapping.isCastingPossible(INST_BOOLEAN, PRIM_BOOLEAN));
        Assert.assertEquals(POSSIBLE, autoBoxingMapping.isCastingPossible(PRIM_BOOLEAN, INST_BOOLEAN));

        Assert.assertEquals(POSSIBLE, autoBoxingMapping.isCastingPossible(INST_BOOLEAN, INST_BOOLEAN));
        Assert.assertEquals(POSSIBLE, autoBoxingMapping.isCastingPossible(PRIM_BOOLEAN, PRIM_BOOLEAN));

        Assert.assertEquals(LIKELY_POSSIBLE, autoBoxingMapping.isCastingPossible(INST_INTEGER, PRIM_FLOAT));
        Assert.assertEquals(LIKELY_POSSIBLE, autoBoxingMapping.isCastingPossible(INST_FLOAT, PRIM_INT));


        Assert.assertEquals(IMPOSSIBLE, autoBoxingMapping.isCastingPossible(INST_BOOLEAN, PRIM_INT));
        Assert.assertEquals(IMPOSSIBLE, autoBoxingMapping.isCastingPossible(INST_BOOLEAN, INST_INTEGER));
        Assert.assertEquals(IMPOSSIBLE, autoBoxingMapping.isCastingPossible(PRIM_BOOLEAN, PRIM_INT));
        Assert.assertEquals(IMPOSSIBLE, autoBoxingMapping.isCastingPossible(PRIM_BOOLEAN, INST_INTEGER));
    }
}
