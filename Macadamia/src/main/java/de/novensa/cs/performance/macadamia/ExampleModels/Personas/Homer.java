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
@SuppressWarnings("UnusedDeclaration")
public class Homer extends Male implements American, Spontanous {

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
}
