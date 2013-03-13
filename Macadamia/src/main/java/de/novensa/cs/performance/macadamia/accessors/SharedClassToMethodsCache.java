package de.novensa.cs.performance.macadamia.accessors;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.TreeMap;

/**
 * The central cache for all ValueAccessorChains for all fields, for all instances, etc. This is possible and valid
 * because Classes and Methods will not evolved while running in the JVM.
 *
 * @author Daniel Schulz
 */
public class SharedClassToMethodsCache {

    private static SharedClassToMethodsCache master = null;
    protected Map<String, Method[]> invokableMethodsCache = new TreeMap<String, Method[]>();
    // TODO: @Daniel: place in here an Apache LRU cache with some maximum size


    public Map<String, Method[]> getCache() {
        return invokableMethodsCache;
    }

    // singleton
    public static SharedClassToMethodsCache getInstance() {
        if (null == master) {
            master = new SharedClassToMethodsCache();
        }

        return master;
    }

    private SharedClassToMethodsCache() {
    }
}
