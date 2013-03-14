package de.novensa.cs.performance.macadamia;

import de.novensa.cs.performance.macadamia.ExampleModels.Nationalities.American;
import de.novensa.cs.performance.macadamia.ExampleModels.Nationalities.French;
import de.novensa.cs.performance.macadamia.ExampleModels.Nature.*;
import de.novensa.cs.performance.macadamia.ExampleModels.Personas.Homer;
import de.novensa.cs.performance.macadamia.ExampleModels.Personas.Marge;
import de.novensa.cs.performance.macadamia.ExampleModels.Personas.Peter;
import de.novensa.cs.performance.macadamia.ExampleModels.Sexes.Female;
import de.novensa.cs.performance.macadamia.ExampleModels.Sexes.Male;
import de.novensa.cs.performance.macadamia.accessors.AutoBoxingMapping;
import junit.framework.TestCase;
import org.junit.Test;

import static de.novensa.cs.performance.macadamia.accessors.ClassCastPrediction.IMPOSSIBLE;
import static de.novensa.cs.performance.macadamia.accessors.ClassCastPrediction.POSSIBLE;

/**
 * Test Java´s advanced inheritances and interfaces.
 *
 * @author Daniel Schulz
 */
@SuppressWarnings("JUnit4AnnotatedMethodInJUnit3TestCase")
public class InheritanceCastingTest extends TestCase {


    private AutoBoxingMapping autoBoxingMapping = new AutoBoxingMapping();

    // Personas
    private static final Class HOMER = (new Homer((short) 40)).getClass();
    private static final Class PETER = (new Peter()).getClass();
    private static final Class MARGE = (new Marge((short) 110)).getClass();

    private static final Class AMERICAN = American.class;
    private static final Class FRENCH = French.class;

    private static final Class HUMAN = Human.class;
    private static final Class LIVING_THINGS = LivingThings.class;
    private static final Class SPONTANEOUS = Spontanous.class;
    private static final Class TOOL_BUILDER = ToolBuilder.class;
    private static final Class THINGS = Things.class;
    private static final Class WORLD_ITEMS = WorldItems.class;

    private static final Class FEMALE = Female.class;
    private static final Class MALE = Male.class;


    @Test
    public void testInheritanceCastings() {
        // Homer
        assertEquals(POSSIBLE, autoBoxingMapping.isCastingPossible(HOMER, HOMER));
        assertEquals(IMPOSSIBLE, autoBoxingMapping.isCastingPossible(HOMER, MARGE));
        assertEquals(IMPOSSIBLE, autoBoxingMapping.isCastingPossible(HOMER, PETER));

        assertEquals(POSSIBLE, autoBoxingMapping.isCastingPossible(HOMER, AMERICAN));
        assertEquals(IMPOSSIBLE, autoBoxingMapping.isCastingPossible(HOMER, FRENCH));

        assertEquals(POSSIBLE, autoBoxingMapping.isCastingPossible(HOMER, HUMAN));
        assertEquals(POSSIBLE, autoBoxingMapping.isCastingPossible(HOMER, LIVING_THINGS));
        assertEquals(POSSIBLE, autoBoxingMapping.isCastingPossible(HOMER, SPONTANEOUS));

        assertEquals(IMPOSSIBLE, autoBoxingMapping.isCastingPossible(HOMER, FEMALE));
        assertEquals(POSSIBLE, autoBoxingMapping.isCastingPossible(HOMER, MALE));


        // Marge
        assertEquals(POSSIBLE, autoBoxingMapping.isCastingPossible(MARGE, HUMAN));
        assertEquals(POSSIBLE, autoBoxingMapping.isCastingPossible(MARGE, LIVING_THINGS));
        assertEquals(IMPOSSIBLE, autoBoxingMapping.isCastingPossible(MARGE, SPONTANEOUS));

        assertEquals(IMPOSSIBLE, autoBoxingMapping.isCastingPossible(MARGE, AMERICAN));
        assertEquals(POSSIBLE, autoBoxingMapping.isCastingPossible(MARGE, FRENCH));


        // Peter
        assertEquals(POSSIBLE, autoBoxingMapping.isCastingPossible(PETER, HUMAN));
        assertEquals(POSSIBLE, autoBoxingMapping.isCastingPossible(PETER, LIVING_THINGS));
        assertEquals(POSSIBLE, autoBoxingMapping.isCastingPossible(PETER, SPONTANEOUS));

        assertEquals(POSSIBLE, autoBoxingMapping.isCastingPossible(PETER, AMERICAN));
        assertEquals(IMPOSSIBLE, autoBoxingMapping.isCastingPossible(PETER, FRENCH));


        // tricky tasks
        assertEquals(POSSIBLE, autoBoxingMapping.isCastingPossible(MARGE, TOOL_BUILDER));
        assertEquals(POSSIBLE, autoBoxingMapping.isCastingPossible(MARGE, THINGS));
        assertEquals(POSSIBLE, autoBoxingMapping.isCastingPossible(MARGE, WORLD_ITEMS));
        assertEquals(POSSIBLE, autoBoxingMapping.isCastingPossible(HOMER, WORLD_ITEMS));
        assertEquals(POSSIBLE, autoBoxingMapping.isCastingPossible(PETER, WORLD_ITEMS));
    }
}
