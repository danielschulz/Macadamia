package de.novensa.cs.performance.macadamia.ExampleModels.Personas;

import de.novensa.cs.performance.macadamia.ExampleModels.Nationalities.French;
import de.novensa.cs.performance.macadamia.ExampleModels.Nature.Hedonist;
import de.novensa.cs.performance.macadamia.ExampleModels.Sexes.Female;

/**
 * An example object for testing purpose.
 *
 * @author Daniel Schulz
 */
@SuppressWarnings("UnusedDeclaration")
public class Marge extends Female implements French, Hedonist {

    private final short iq;

    public Marge(short iq) {
        super("Homer Simpson", 1.8f);
        this.iq = iq;
    }

    public short getIq() {
        return iq;
    }

    @Override
    public boolean consumeCulture() {
        return true;
    }

    @Override
    public void enjoy() {
    }
}
