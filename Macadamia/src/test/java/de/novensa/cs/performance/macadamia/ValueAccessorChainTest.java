package de.novensa.cs.performance.macadamia;

import de.novensa.cs.performance.macadamia.accessors.ValueAccessorChain;
import org.junit.Test;

/**
 * Technical test for ValueAccessorChain.
 *
 * @author Daniel Schulz
 */
public class ValueAccessorChainTest {

    @Test
    public void testBasic() throws ClassNotFoundException {
        Class<?> c = Class.forName("java.lang.String");
        ValueAccessorChain chain = new ValueAccessorChain(c);

        chain.addUpcomingElement(c);                    // cast to String
        chain.addUpcomingElement(c.getMethods()[1]);    // .toString()
    }
}
