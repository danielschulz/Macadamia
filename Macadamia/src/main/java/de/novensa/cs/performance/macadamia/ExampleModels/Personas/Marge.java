package de.novensa.cs.performance.macadamia.examplemodels.personas;

import de.novensa.cs.performance.macadamia.examplemodels.nationalities.French;
import de.novensa.cs.performance.macadamia.examplemodels.nature.Hedonist;
import de.novensa.cs.performance.macadamia.examplemodels.sexes.Female;

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
