package de.novensa.cs.performance.macadamia.examplemodels.personas;

import de.novensa.cs.performance.macadamia.examplemodels.nationalities.American;
import de.novensa.cs.performance.macadamia.examplemodels.nature.Spontanous;
import de.novensa.cs.performance.macadamia.examplemodels.sexes.Male;

import java.util.Locale;

/**
 * An example object for testing purpose.
 *
 * @author Daniel Schulz
 */
@SuppressWarnings("UnusedDeclaration")
public class Peter extends Male implements American, Spontanous {

    private final short iq;

    public Peter() {
        super("Peter Griffin", 1.7f);
        this.iq = (short) 20;
    }

    public short getIq() {
        return iq;
    }

    @Override
    public boolean singAnthem(Locale locale) {
        return false;
    }

    @Override
    public void actStupid() {
        throw new IllegalStateException();
    }
}
