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
    private Map<IndexType, AbstractAccessor<T>> indexes = new TreeMap<IndexType, AbstractAccessor<T>>();


    /*
    Initialization
     */
    public Macadamia(List<T> objects, String... reflectiveAttributes) {
        this.objects = objects;
    }

    public Macadamia(T... objects) {
        Collections.addAll(this.objects, objects);
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
