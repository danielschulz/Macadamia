package de.novensa.cs.performance.macadamia.examplemodels.sexes;

import de.novensa.cs.performance.macadamia.examplemodels.nature.Human;

/**
 * An example object for testing purpose.
 *
 * @author Daniel Schulz
 */
@SuppressWarnings("UnusedDeclaration")
public abstract class Female extends Human {

    public Female(String name, float high) {
        super(name, high);
    }

    public final void dance(Male male) {
        male.dance();
    }
}
