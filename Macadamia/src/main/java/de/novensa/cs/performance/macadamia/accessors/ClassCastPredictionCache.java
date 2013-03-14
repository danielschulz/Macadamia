package de.novensa.cs.performance.macadamia.accessors;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Caches to Class from-to combination with it´s prediction result.
 *
 * @author Daniel Schulz
 */
@SuppressWarnings("UnusedDeclaration")
public class ClassCastPredictionCache<R, S, T> extends AbstractPerfomanceMeteredCache
        implements Level2RisingCache<R, S, T> {

    private Map<R, Map<S, T>> cache = new LinkedHashMap<R, Map<S, T>>(this.numberOfEntriesToExpect);

    public ClassCastPredictionCache(int numberOfEntriesToExpect) {
        super(numberOfEntriesToExpect);
        this.cache = new LinkedHashMap<R, Map<S, T>>(this.numberOfEntriesToExpect);
    }

    public boolean hasPrediction(R from, S to) {
        Map<S, T> inBetween = this.cache.get(from);
        boolean predAvailable = null != inBetween && null != inBetween.get(to);

        // performance metrics
        if (predAvailable) {
            requestsAnsweredFromCache++;
        } else {
            requestsHadToBeCalculated++;
        }
        return predAvailable;
    }

    public T getPrediction(R from, S to) {
        Map<S, T> inBetween = this.cache.get(from);
        return null != inBetween ? inBetween.get(to) : null;
    }

    public void add(R from, S to, T prediction) {
        Map<S, T> levelOne = this.cache.get(from);
        if (null != levelOne) {
            T levelTwo = levelOne.get(to);
            if (null != levelTwo) {
                forceAddPrediction(from, to, prediction);
            } else {
                // level two was not found
                levelOne.put(to, prediction);
            }
        } else {
            // level one was not found
            forceAddPrediction(from, to, prediction);
        }
    }

    private void forceAddPrediction(R from, S to, T prediction) {
        Map<S, T> toToPrediction = new LinkedHashMap<S, T>();
        toToPrediction.put(to, prediction);
        this.cache.put(from, toToPrediction);
    }
}
