package de.novensa.cs.performance.macadamia.examplemodels.Personas;

import de.novensa.cs.performance.macadamia.examplemodels.Nationalities.American;
import de.novensa.cs.performance.macadamia.examplemodels.Nature.Spontanous;
import de.novensa.cs.performance.macadamia.examplemodels.Sexes.Male;

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
