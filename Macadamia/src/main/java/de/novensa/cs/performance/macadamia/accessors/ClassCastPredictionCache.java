package de.novensa.cs.performance.macadamia.accessors;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Caches to Class from-to combination with it´s prediction result.
 *
 * @author Daniel Schulz
 */
@SuppressWarnings("UnusedDeclaration")
public class ClassCastPredictionCache {

    private Map<Class, Map<Class, ClassCastPrediction>> cache = new LinkedHashMap<Class, Map<Class, ClassCastPrediction>>();

    public ClassCastPredictionCache() {
        this.cache = new LinkedHashMap<Class, Map<Class, ClassCastPrediction>>();
    }

    public boolean hasPrediction(Class from, Class to) {
        Map<Class, ClassCastPrediction> inBetween = this.cache.get(from);
        return null != inBetween && null != inBetween.get(to);
    }

    public ClassCastPrediction getPrediction(Class from, Class to) {
        Map<Class, ClassCastPrediction> inBetween = this.cache.get(from);
        return null != inBetween ? inBetween.get(to) : null;
    }

    public void add(Class from, Class to, ClassCastPrediction prediction) {
        Map<Class, ClassCastPrediction> levelOne = this.cache.get(from);
        if (null != levelOne) {
            ClassCastPrediction levelTwo = levelOne.get(to);
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

    private void forceAddPrediction(Class from, Class to, ClassCastPrediction prediction) {
        Map<Class, ClassCastPrediction> toToPrediction = new LinkedHashMap<Class, ClassCastPrediction>();
        toToPrediction.put(to, prediction);
        this.cache.put(from, toToPrediction);
    }
}
