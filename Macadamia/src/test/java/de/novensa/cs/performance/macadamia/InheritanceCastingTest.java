package de.novensa.cs.performance.macadamia;

import de.novensa.cs.performance.macadamia.ExampleModels.Nationalities.American;
import de.novensa.cs.performance.macadamia.ExampleModels.Nationalities.French;
import de.novensa.cs.performance.macadamia.ExampleModels.Nature.Human;
import de.novensa.cs.performance.macadamia.ExampleModels.Nature.LivingThings;
import de.novensa.cs.performance.macadamia.ExampleModels.Nature.Spontanous;
import de.novensa.cs.performance.macadamia.ExampleModels.Personas.Homer;
import de.novensa.cs.performance.macadamia.ExampleModels.Personas.Marge;
import de.novensa.cs.performance.macadamia.ExampleModels.Personas.Peter;
import de.novensa.cs.performance.macadamia.ExampleModels.Sexes.Female;
import de.novensa.cs.performance.macadamia.ExampleModels.Sexes.Male;
import de.novensa.cs.performance.macadamia.accessors.AutoBoxingMapping;
import de.novensa.cs.performance.macadamia.accessors.ClassCastPrediction;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Test Java´s advanced inheritances and interfaces.
 *
 * @author Daniel Schulz
 */
public class InheritanceCastingTest extends TestCase {

    // Personas
    private static final Class HOMER = (new Homer((short) 40)).getClass();
    private static final Class PETER = (new Peter()).getClass();
    private static final Class MARGE = (new Marge((short) 110)).getClass();

    private static final Class AMERICAN = American.class;
    private static final Class FRENCH = French.class;

    private static final Class HUMAN = Human.class;
    private static final Class LIVING_THINGS = LivingThings.class;
    private static final Class SPONTANEOUS = Spontanous.class;

    private static final Class FEMALE = Female.class;
    private static final Class MALE = Male.class;



    @Test
    public void testInheritanceCastings() {
        // Homer
        assertEquals(ClassCastPrediction.POSSIBLE, AutoBoxingMapping.isCastingPossible(HOMER, HOMER));
        assertEquals(ClassCastPrediction.IMPOSSIBLE, AutoBoxingMapping.isCastingPossible(HOMER, MARGE));
        assertEquals(ClassCastPrediction.IMPOSSIBLE, AutoBoxingMapping.isCastingPossible(HOMER, PETER));


        assertEquals(ClassCastPrediction.POSSIBLE, AutoBoxingMapping.isCastingPossible(HOMER, AMERICAN));
        assertEquals(ClassCastPrediction.IMPOSSIBLE, AutoBoxingMapping.isCastingPossible(HOMER, FRENCH));

        assertEquals(ClassCastPrediction.POSSIBLE, AutoBoxingMapping.isCastingPossible(HOMER, HUMAN));
        assertEquals(ClassCastPrediction.POSSIBLE, AutoBoxingMapping.isCastingPossible(HOMER, LIVING_THINGS));
        assertEquals(ClassCastPrediction.POSSIBLE, AutoBoxingMapping.isCastingPossible(HOMER, SPONTANEOUS));

        assertEquals(ClassCastPrediction.IMPOSSIBLE, AutoBoxingMapping.isCastingPossible(HOMER, FEMALE));
        assertEquals(ClassCastPrediction.POSSIBLE, AutoBoxingMapping.isCastingPossible(HOMER, MALE));


        // Marge
        assertEquals(ClassCastPrediction.POSSIBLE, AutoBoxingMapping.isCastingPossible(MARGE, HUMAN));
        assertEquals(ClassCastPrediction.POSSIBLE, AutoBoxingMapping.isCastingPossible(MARGE, LIVING_THINGS));
        assertEquals(ClassCastPrediction.IMPOSSIBLE, AutoBoxingMapping.isCastingPossible(MARGE, SPONTANEOUS));

        assertEquals(ClassCastPrediction.IMPOSSIBLE, AutoBoxingMapping.isCastingPossible(MARGE, AMERICAN));
        assertEquals(ClassCastPrediction.POSSIBLE, AutoBoxingMapping.isCastingPossible(MARGE, FRENCH));


        // Peter
        assertEquals(ClassCastPrediction.POSSIBLE, AutoBoxingMapping.isCastingPossible(PETER, HUMAN));
        assertEquals(ClassCastPrediction.POSSIBLE, AutoBoxingMapping.isCastingPossible(PETER, LIVING_THINGS));
        assertEquals(ClassCastPrediction.POSSIBLE, AutoBoxingMapping.isCastingPossible(PETER, SPONTANEOUS));

        assertEquals(ClassCastPrediction.POSSIBLE, AutoBoxingMapping.isCastingPossible(PETER, AMERICAN));
        assertEquals(ClassCastPrediction.IMPOSSIBLE, AutoBoxingMapping.isCastingPossible(PETER, FRENCH));
    }
}
