package de.novensa.cs.performance.macadamia.accessors.caches;

public interface Level2RisingCache<R, S, T> {

    public boolean hasPrediction(R from, S to);

    public void add(R from, S to, T prediction);
}
