package de.novensa.cs.performance.macadamia;

import de.novensa.cs.performance.macadamia.accessors.AbstractAccessor;

import java.util.*;

/**
 * The data structures holding instance.
 *
 * @author Daniel Schulz
 */
@SuppressWarnings("UnusedDeclaration")
public class Macadamia<T> {

    private List<T> objects;
    private Collection<String> reflectiveAttributes;
    private Map<IndexType, AbstractAccessor<T>> indices;

    public void updateIndices() {
        for (AbstractAccessor accessor : this.indices.values()) {
            accessor.updateIndex();
        }
    }

    /*
    Initialization
     */
    public Macadamia(List<T> objects, String... reflectiveAttributes) {
        this.objects = objects;
        this.indices = new TreeMap<IndexType, AbstractAccessor<T>>();
    }

    public Macadamia(T... objects) {
        Collections.addAll(this.objects, objects);
        this.indices = new TreeMap<IndexType, AbstractAccessor<T>>();
    }

    public Macadamia(String... reflectiveAttributes) {
        Collections.addAll(this.reflectiveAttributes, reflectiveAttributes);
        this.indices = new TreeMap<IndexType, AbstractAccessor<T>>();
    }

    public void setReflectiveAttributes(String... reflectiveAttributes) {
        Collections.addAll(this.reflectiveAttributes, reflectiveAttributes);
    }

    public void addObjects(List<T> objects) {
        this.objects.addAll(objects);
    }


    /*
    Getter and setter
     */
    public List<T> getObjects() {
        return objects;
    }

    public void setObjects(List<T> objects) {
        this.objects = objects;
    }

    public Collection<String> getReflectiveAttributes() {
        return reflectiveAttributes;
    }

    public void setReflectiveAttributes(Collection<String> reflectiveAttributes) {
        this.reflectiveAttributes = reflectiveAttributes;
    }
}
