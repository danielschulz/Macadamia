package de.novensa.cs.performance.macadamia.management.jvm.util;

import java.util.Comparator;

/**
 * Maps the <code>reflectiveReference</code> entries to it´s specific <code>JvmResourceDetails</code> within
 * the entire container.
 *
 * @author Daniel Schulz
 */
public class ReflectiveReferenceToResourceDetailsComparator<T extends Comparable> implements Comparator<T> {

    // specific super overwrites
    @Override
    public int compare(final T oneItem, final T anotherItem) {
        //noinspection unchecked
        return oneItem.compareTo(anotherItem);
    }

    @Override
    public boolean equals(final Object obj) {
        return obj instanceof Comparable && obj == this;
    }
}
