package de.novensa.cs.performance.macadamia.examplemodels.personas;

import de.novensa.cs.performance.macadamia.examplemodels.nationalities.American;
import de.novensa.cs.performance.macadamia.examplemodels.nature.Hedonist;
import de.novensa.cs.performance.macadamia.examplemodels.nature.Spontanous;
import de.novensa.cs.performance.macadamia.examplemodels.sexes.Male;

import java.util.Locale;

/**
 * An example object for testing purpose.
 *
 * @author Daniel Schulz
 */
@SuppressWarnings("UnusedDeclaration")
public class Homer extends Male implements American, Spontanous, Hedonist {

    private final short iq;

    public Homer(short iq) {
        super("Homer Simpson", 1.8f);
        this.iq = iq;
    }

    public short getIq() {
        return iq;
    }

    @Override
    public boolean singAnthem(Locale locale) {
        return true;
    }

    @Override
    public void actStupid() {
        throw new IllegalStateException();
    }

    @Override
    public void enjoy() {
    }
}
