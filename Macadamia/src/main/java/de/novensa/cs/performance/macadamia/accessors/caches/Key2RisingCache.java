package de.novensa.cs.performance.macadamia.accessors.caches;

/**
 * Defines an interface for caches that only will be filled but never tend updated nor removed anything off. The only
 * possibility to get rid of them will be invalidating all caches in Macadamia.
 *
 * @author Daniel Schulz
 *
 * @param <R> The instance type for the first mapping (row)
 * @param <F> The instance type for the next mapping (column)
 * @param <V> The outcome of the intersect of row (R) and column (F)
 */

public interface Key2RisingCache<R, F, V> {

    public V get(R from, F to);

    public boolean hasKey(R roughKey, F fineKey);

    public void add(R roughKey, F fineKey, V value);
}
