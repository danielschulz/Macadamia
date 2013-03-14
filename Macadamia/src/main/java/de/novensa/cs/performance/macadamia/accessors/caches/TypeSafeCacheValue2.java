package de.novensa.cs.performance.macadamia.accessors.caches;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * A cache to store all the JVM related information.
 *
 * @author Daniel Schulz
 */
@SuppressWarnings("UnusedDeclaration")
public class TypeSafeCacheValue2<C, M, I> extends AbstractPerfomanceMeteredCache implements Value2RisingCache<C, M, I> {

    private Map<C, M> mappingToMethods;
    private Map<C, I> mappingToInterfaces;

    public TypeSafeCacheValue2(int numberOfEntriesToExpect) {
        super(numberOfEntriesToExpect);
        mappingToMethods = new LinkedHashMap<C, M>(numberOfEntriesToExpect);
        mappingToInterfaces = new LinkedHashMap<C, I>(numberOfEntriesToExpect);
    }

    @Override
    public boolean hasKey(C key) {
        return null != mappingToMethods.get(key);
    }

    @Override
    public void add(C key, M value1, I value2) {
        mappingToMethods.put(key, value1);
        mappingToInterfaces.put(key, value2);
    }

    @Override
    public M getValue1(C key) {
        return mappingToMethods.get(key);
    }

    @Override
    public I getValue2(C key) {
        return mappingToInterfaces.get(key);
    }
}
