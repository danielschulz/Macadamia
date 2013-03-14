package de.novensa.cs.performance.macadamia.accessors.caches;

/**
 * Defines an interface for caches that only will be filled but never tend updated nor removed anything off. The only
 * possibility to get rid of them will be invalidating all caches in Macadamia.
 *
 * @author Daniel Schulz
 *
 * @param <K> The key for the mapping
 * @param <V1> The first outcome of the mapping
 * @param <V2> The second outcome of the mapping
 */

public interface Value2RisingCache<K, V1, V2> {

    public boolean hasKey(K key);

    public void add(K key, V1 value1, V2 value2);

    public V1 getValue1(K key);

    public V2 getValue2(K key);
}
