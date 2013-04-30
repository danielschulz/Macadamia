package de.novensa.cs.performance.macadamia.examplemodels.nationalities;

import java.util.Locale;

/**
 * An example object for testing purpose.
 *
 * @author Daniel Schulz
 */
@SuppressWarnings("UnusedDeclaration")
public interface French {

    public static final Locale accent = Locale.FRENCH;

    public boolean consumeCulture();
}
