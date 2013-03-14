package de.novensa.cs.performance.macadamia.indexes;

import de.novensa.cs.performance.macadamia.accessors.AbstractAccessor;

import java.util.*;

/**
 * The data structures holding instance.
 *
 * @author Daniel Schulz
 */
@SuppressWarnings("UnusedDeclaration")
public  class IndicesController<T> {

    protected Map<IndexType, AbstractAccessor<T>> indices;

    public void updateIndices() {
        for (AbstractAccessor accessor : this.indices.values()) {
            accessor.updateIndex();
        }
    }

    /*
    Initialization
     */
    public IndicesController(List<T> objects, Collection<String> reflectiveAttributes) {
        this.indices = new TreeMap<IndexType, AbstractAccessor<T>>();
    }

    public IndicesController(List<T> objects, String... reflectiveAttributes) {
        this.indices = new TreeMap<IndexType, AbstractAccessor<T>>();
    }

    public IndicesController(Collection<T> objects) {
        this.indices = new TreeMap<IndexType, AbstractAccessor<T>>();
    }

    public IndicesController(T... objects) {
        this.indices = new TreeMap<IndexType, AbstractAccessor<T>>();
    }




    /*
    Getter and setter
     */

}
