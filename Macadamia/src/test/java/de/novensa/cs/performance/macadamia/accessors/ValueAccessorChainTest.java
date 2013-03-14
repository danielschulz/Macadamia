package de.novensa.cs.performance.macadamia.accessors;

import de.novensa.cs.performance.macadamia.ExampleModels.Personas.Homer;
import de.novensa.cs.performance.macadamia.ExampleModels.Personas.Peter;
import de.novensa.cs.performance.macadamia.InheritanceTestObjects;
import org.junit.Test;

/**
 * TestCase for ValueAccessChain.
 *
 * @author Daniel Schulz
 */
public class ValueAccessorChainTest extends InheritanceTestObjects {

    @Test
    public void testApplicableMethods() throws ClassNotFoundException {

        Class<?> c = Class.forName("java.lang.String");
        ValueAccessorChain chain = new ValueAccessorChain(c);

        chain.addUpcomingElement(c);                    // cast to String
        chain.addUpcomingElement(c.getMethods()[1]);    // .toString()
    }

    @Test
    public void testApplicableMthods2() {
        ValueAccessorChain chain = new ValueAccessorChain(Homer.class);
        chain.addUpcomingElement(Peter.class);
    }
}
