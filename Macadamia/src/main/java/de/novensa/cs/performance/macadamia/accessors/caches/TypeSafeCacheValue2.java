package de.novensa.cs.performance.macadamia.accessors.caches;

/**
 * A cache to store all the JVM related information.
 *
 * @author Daniel Schulz
 */
public class TypeSafeCacheValue2<C, M, I> extends AbstractPerfomanceMeteredCache implements Value2RisingCache<C, M, I> {

    public TypeSafeCacheValue2(int numberOfEntriesToExpect) {
        super(numberOfEntriesToExpect);
    }

    @Override
    public boolean hasKey(C key) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void add(C key, M value1, I value2) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
