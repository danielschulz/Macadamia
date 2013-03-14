package de.novensa.cs.performance.macadamia.accessors.caches;

import de.novensa.cs.performance.macadamia.accessors.AdvancedJavaCastingRules;
import de.novensa.cs.performance.macadamia.accessors.AutoBoxingMapping;
import de.novensa.cs.performance.macadamia.util.strategic.ClassCastPrediction;
import de.novensa.cs.performance.macadamia.util.Constants;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

import static de.novensa.cs.performance.macadamia.util.strategic.ClassCastPrediction.*;
import static de.novensa.cs.performance.macadamia.messaging.ErrorMessages.NULL_ARGUMENTS_NOT_ALLOWED_HERE;

/**
 * The central cache for all ValueAccessorChains for all fields, for all instances, etc. This is possible and valid
 * because Classes and Methods will not evolved while running in the JVM.
 *
 * @author Daniel Schulz
 */
public class SharedClassCache {

    private static SharedClassCache instance = null;
    protected Map<Class, LinkedHashSet<Method>> invokableMethodsCache = new HashMap<Class, LinkedHashSet<Method>>();
    private ClassCastPredictionCache<Class, Class, ClassCastPrediction> classCastPredictionCache =
            new ClassCastPredictionCache<Class, Class, ClassCastPrediction>(
                    Constants.INITIAL_SIZE_OF_CLASS_TO_CLASS_TO_PREDICTION_CACHE);
    // TODO: @Daniel: place in here an Apache LRU cache with some maximum size


    public Map<Class, LinkedHashSet<Method>> getCache() {
        return invokableMethodsCache;
    }


    // test casting possibilities
    public ClassCastPrediction isCastingPossible(Class from, Class to) {
        if (null == from || null == to) {
            throw new IllegalArgumentException(NULL_ARGUMENTS_NOT_ALLOWED_HERE);
        }

        ClassCastPrediction autoBoxingResult = classCastPredictionCache.hasPrediction(from, to) ?
                classCastPredictionCache.getPrediction(from, to) : isAutoBoxingCastingPossible(from, to);
        if (!CANNOT_BE_TOLD.equals(autoBoxingResult)) {
            // we have an answer
            classCastPredictionCache.add(from, to, autoBoxingResult);
            return autoBoxingResult;
        } else {
            // if auto boxing cannot be sure enough go on using inheritance, implementation´s, and other techniques
            ClassCastPrediction predictionByInheritance =
                    AdvancedJavaCastingRules.isCastingPossibleByInheritance(from, to, classCastPredictionCache);
            classCastPredictionCache.add(from, to, predictionByInheritance);
            return predictionByInheritance;
        }
    }

    @SuppressWarnings("UnusedDeclaration")
    public boolean isCastingPossibleBoolean(Class from, Class to) {
        return !IMPOSSIBLE.equals(isCastingPossible(from, to));
    }

    private ClassCastPrediction isAutoBoxingCastingPossible(Class from, Class to) {

        // no cast will be performed because target state equals initial state
        if (from.equals(to)) {
            return POSSIBLE;
        }

        // cast everything to Object is no problem
        if (Constants.OBJECT.equals(to)) {
            return POSSIBLE;
        }

        if (AutoBoxingMapping.isClassInIndex(from)) {
            // iff both are in indices do not allow possible isolation-violation
            // no cross-wise castings possible
            if(AutoBoxingMapping.isClassInIndex(to) &&
                    (AutoBoxingMapping.ISOLATED_SET.contains(from) || AutoBoxingMapping.ISOLATED_SET.contains(to))) {
                return // pick correct index
                        to.equals((from.isPrimitive() ?
                                AutoBoxingMapping.FORWARD_TRIVIAL_INDEX :
                                AutoBoxingMapping.BACKWARD_TRIVIAL_INDEX).get(from)) ?
                                // tell the prediction
                                POSSIBLE : IMPOSSIBLE;
            }

            return LIKELY_POSSIBLE;
        }


        Class result = from.isPrimitive() ?
                AutoBoxingMapping.FORWARD_TRIVIAL_INDEX.get(from) : AutoBoxingMapping.BACKWARD_TRIVIAL_INDEX.get(from);

        // null == result: class is not present in it's index
        if (null == result) {
            return CANNOT_BE_TOLD;
        }


        if (to.equals(result)) {
            return LIKELY_POSSIBLE;
        }

        return CANNOT_BE_TOLD;
    }

    // override
    @Override
    public Object clone() throws CloneNotSupportedException {
        super.clone();
        throw new CloneNotSupportedException();
    }

    // singleton
    public static synchronized SharedClassCache getInstance() {
        if (null == instance) {
            instance = new SharedClassCache();
        }

        return instance;
    }

    private SharedClassCache() {
    }
}
