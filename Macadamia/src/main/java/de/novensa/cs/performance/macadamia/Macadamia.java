package de.novensa.cs.performance.macadamia;

import de.novensa.cs.performance.macadamia.indexes.IndicesController;

import java.util.*;

/**
 * The data structures controlling instance and facade for data magic.
 *
 * @author Daniel Schulz
 */
@SuppressWarnings("UnusedDeclaration")
public class Macadamia<T> extends IndicesController<T> {

    private List<T> objects;
    private Collection<String> reflectiveAttributes;


    // major initialization
    public Macadamia(List<T> objects, String... reflectiveAttributes) {
        super(objects, reflectiveAttributes);
        this.objects = objects;
    }

    public Macadamia(T... objects) {
        super(objects);
        Collections.addAll(this.objects, objects);
    }

    public Macadamia(String... reflectiveAttributes) {
        Collections.addAll(this.reflectiveAttributes, reflectiveAttributes);
    }

    public void setReflectiveAttributes(String... reflectiveAttributes) {
        Collections.addAll(this.reflectiveAttributes, reflectiveAttributes);
    }

    public void addObjects(List<T> objects) {
        this.objects.addAll(objects);
    }


    // basic bean members
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
