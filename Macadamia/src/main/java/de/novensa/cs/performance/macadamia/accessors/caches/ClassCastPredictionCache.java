package de.novensa.cs.performance.macadamia.accessors.caches;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Caches to Class from-to combination with it´s prediction result.
 *
 * @author Daniel Schulz
 */
@SuppressWarnings("UnusedDeclaration")
public class ClassCastPredictionCache<R, F, V> extends AbstractPerfomanceMeteredCache
        implements Key2RisingCache<R, F, V> {

    private Map<R, Map<F, V>> cache = new LinkedHashMap<R, Map<F, V>>(this.numberOfEntriesToExpect);

    public ClassCastPredictionCache(int numberOfEntriesToExpect) {
        super(numberOfEntriesToExpect);
        this.cache = new LinkedHashMap<R, Map<F, V>>(this.numberOfEntriesToExpect);
    }

    public boolean hasKey(R roughKey, F fineKey) {
        Map<F, V> inBetween = this.cache.get(roughKey);
        boolean predAvailable = null != inBetween && null != inBetween.get(fineKey);

        // performance metrics
        if (predAvailable) {
            requestsAnsweredFromCache++;
        } else {
            requestsHadToBeCalculated++;
        }
        return predAvailable;
    }

    public V getPrediction(R from, F to) {
        Map<F, V> inBetween = this.cache.get(from);
        return null != inBetween ? inBetween.get(to) : null;
    }

    public void add(R roughKey, F fineKey, V value) {
        Map<F, V> levelOne = this.cache.get(roughKey);
        if (null != levelOne) {
            V levelTwo = levelOne.get(fineKey);
            if (null != levelTwo) {
                forceAddPrediction(roughKey, fineKey, value);
            } else {
                // level two was not found
                levelOne.put(fineKey, value);
            }
        } else {
            // level one was not found
            forceAddPrediction(roughKey, fineKey, value);
        }
    }

    private void forceAddPrediction(R from, F to, V prediction) {
        Map<F, V> toToPrediction = new LinkedHashMap<F, V>();
        toToPrediction.put(to, prediction);
        this.cache.put(from, toToPrediction);
    }
}
