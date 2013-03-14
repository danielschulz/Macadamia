package de.novensa.cs.performance.macadamia.accessors.caches;

/**
 * Defines an interface for caches that only will be filled but never tend updated nor removed anything off. The only
 * possibility to get rid of them will be invalidating all caches in Macadamia.
 *
 * @author Daniel Schulz
 *
 * @param <R> The instance type for the first mapping (row)
 * @param <S> The instance type for the next mapping (column)
 * @param <T> The outcome of the intersect of row (R) and column (S) and the type of the prediction
 */

public interface Level2RisingCache<R, S, T> {

    public boolean hasPrediction(R from, S to);

    public void add(R from, S to, T prediction);
}
