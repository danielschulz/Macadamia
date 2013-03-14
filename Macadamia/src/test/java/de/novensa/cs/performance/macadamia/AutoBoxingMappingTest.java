package de.novensa.cs.performance.macadamia;

import de.novensa.cs.performance.macadamia.accessors.AutoBoxingMapping;
import de.novensa.cs.performance.macadamia.accessors.ClassCastPrediction;
import junit.framework.TestCase;
import org.junit.Test;
import static de.novensa.cs.performance.macadamia.util.Constants.OBJECT;

/**
 * The test case for the auto boxing mapping.
 *
 * @author Daniel Schulz
 */
public class AutoBoxingMappingTest extends TestCase {

    private static final Class INST_INTEGER = Integer.class;
    private static final Class PRIM_INT = int.class;
    private static final Class INST_FLOAT = Float.class;
    private static final Class PRIM_FLOAT = float.class;

    private static final Class INST_BOOLEAN = Boolean.class;
    private static final Class PRIM_BOOLEAN = boolean.class;

    private static final Class STRING = String.class;

    @Test
    public static void testAutoBoxingMappings() {

        assertEquals(ClassCastPrediction.POSSIBLE, AutoBoxingMapping.isCastingPossible(STRING, STRING));

        assertEquals(ClassCastPrediction.LIKELY_POSSIBLE, AutoBoxingMapping.isCastingPossible(INST_INTEGER, PRIM_INT));
        assertEquals(ClassCastPrediction.LIKELY_POSSIBLE, AutoBoxingMapping.isCastingPossible(PRIM_INT, INST_INTEGER));
        assertEquals(ClassCastPrediction.LIKELY_POSSIBLE, AutoBoxingMapping.isCastingPossible(INST_FLOAT, PRIM_FLOAT));
        assertEquals(ClassCastPrediction.LIKELY_POSSIBLE, AutoBoxingMapping.isCastingPossible(PRIM_FLOAT, INST_FLOAT));

        System.out.println(AutoBoxingMapping.isCastingPossible(INST_FLOAT, OBJECT));
        System.out.println(AutoBoxingMapping.isCastingPossible(INST_INTEGER, OBJECT));
        System.out.println(AutoBoxingMapping.isCastingPossible(PRIM_FLOAT, OBJECT));
        System.out.println(AutoBoxingMapping.isCastingPossible(PRIM_INT, OBJECT));

        System.out.println(AutoBoxingMapping.isCastingPossible(INST_BOOLEAN, PRIM_BOOLEAN));
        System.out.println(AutoBoxingMapping.isCastingPossible(PRIM_BOOLEAN, INST_BOOLEAN));

        System.out.println(AutoBoxingMapping.isCastingPossible(INST_BOOLEAN, INST_BOOLEAN));
        System.out.println(AutoBoxingMapping.isCastingPossible(PRIM_BOOLEAN, PRIM_BOOLEAN));
    }
}
