package de.novensa.cs.performance.macadamia.ExampleModels.Sexes;

import de.novensa.cs.performance.macadamia.ExampleModels.Nature.Human;

/**
 * An example object for testing purpose.
 *
 * @author Daniel Schulz
 */
public abstract class Male extends Human {

    public Male(String name, float high) {
        super(name, high);
    }

    public final void dance() {
        throw new UnsupportedOperationException();
    }
}
