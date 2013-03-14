package de.novensa.cs.performance.macadamia.examplemodels.Sexes;

import de.novensa.cs.performance.macadamia.examplemodels.Nature.Human;

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
