package de.novensa.cs.performance.macadamia.accessors;

import de.novensa.cs.performance.macadamia.IndexType;

/**
 * Access interface. This will define data CRUD techniques.
 *
 * @author Daniel Schulz
 */
@SuppressWarnings("UnusedDeclaration")
public interface AbstractAccessor<T> {

    public boolean contains(T obj);

    public boolean add(T obj, IndexType indexType);


    public void updateIndex();
}
