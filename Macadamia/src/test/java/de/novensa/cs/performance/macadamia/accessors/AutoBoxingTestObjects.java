package de.novensa.cs.performance.macadamia.accessors;

import de.novensa.cs.performance.macadamia.accessors.caches.SharedClassCache;

/**
 * The auto boxing objects to test onto.
 *
 * @author Daniel Schulz
 */
public abstract class AutoBoxingTestObjects {

    static SharedClassCache sharedClassCache = SharedClassCache.getInstance();

    static final Class INST_INTEGER = Integer.class;
    static final Class PRIM_INT = int.class;
    static final Class INST_FLOAT = Float.class;
    static final Class PRIM_FLOAT = float.class;

    static final Class INST_BOOLEAN = Boolean.class;
    static final Class PRIM_BOOLEAN = boolean.class;
}
