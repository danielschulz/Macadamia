package de.novensa.cs.performance.macadamia.util.strategic;

/**
 * Provides necessary settings for the instantiation of caches and indices.
 *
 * @author Daniel Schulz
 */
@SuppressWarnings("UnusedDeclaration")
public class RuntimeInformation {

    private static RuntimeInformation instance;


    // singleton

    public static synchronized RuntimeInformation getInstance() {
        if (null == instance) {
            instance = new RuntimeInformation();
        }

        return instance;
    }

    private RuntimeInformation() {
    }
}
