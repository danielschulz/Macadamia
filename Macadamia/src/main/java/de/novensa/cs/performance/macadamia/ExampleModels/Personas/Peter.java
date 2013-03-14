package de.novensa.cs.performance.macadamia.ExampleModels.Personas;

import de.novensa.cs.performance.macadamia.ExampleModels.Nationalities.American;
import de.novensa.cs.performance.macadamia.ExampleModels.Nature.Spontanous;
import de.novensa.cs.performance.macadamia.ExampleModels.Sexes.Male;

import java.util.Locale;

/**
 * An example object for testing purpose.
 *
 * @author Daniel Schulz
 */
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
