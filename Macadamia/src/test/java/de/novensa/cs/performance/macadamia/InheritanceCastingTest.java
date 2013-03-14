package de.novensa.cs.performance.macadamia;

import de.novensa.cs.performance.macadamia.ExampleModels.Personas.Homer;
import de.novensa.cs.performance.macadamia.ExampleModels.Personas.Marge;
import de.novensa.cs.performance.macadamia.ExampleModels.Personas.Peter;
import de.novensa.cs.performance.macadamia.accessors.AutoBoxingMapping;
import org.junit.Test;

/**
 * Test Java´s advanced inheritances and interfaces.
 *
 * @author Daniel Schulz
 */
public class InheritanceCastingTest {

    // Personas
    private static final Class HOMER = (new Homer((short) 40)).getClass();
    private static final Class PETER = (new Peter()).getClass();
    private static final Class MARGE = (new Marge((short) 110)).getClass();

    @Test
    public void testInheritanceCastings() {
        System.out.println(AutoBoxingMapping.isCastingPossible(HOMER, HOMER));
        System.out.println(AutoBoxingMapping.isCastingPossible(HOMER, MARGE));
        System.out.println(AutoBoxingMapping.isCastingPossible(HOMER, PETER));
    }
}
