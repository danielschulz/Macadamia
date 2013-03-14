package de.novensa.cs.performance.macadamia.accessors;

import de.novensa.cs.performance.macadamia.util.Constants;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

import static de.novensa.cs.performance.macadamia.accessors.ClassCastPrediction.*;

/**
 * The central cache for all ValueAccessorChains for all fields, for all instances, etc. This is possible and valid
 * because Classes and Methods will not evolved while running in the JVM.
 *
 * @author Daniel Schulz
 */
public class SharedClassCache {

    private static SharedClassCache master = null;
    protected Map<Class, LinkedHashSet<Method>> invokableMethodsCache = new HashMap<Class, LinkedHashSet<Method>>();
    // TODO: @Daniel: place in here an Apache LRU cache with some maximum size


    public Map<Class, LinkedHashSet<Method>> getCache() {
        return invokableMethodsCache;
    }


    // test casting possibilities

    public ClassCastPrediction isCastPossibleInternal(Class from, Class to) {

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
            if(AutoBoxingMapping.isClassInIndex(to) && AutoBoxingMapping.ISOLATED_SET.contains(from)) {
                return // pick correct index
                        to.equals((from.isPrimitive() ? AutoBoxingMapping.FORWARD_TRIVIAL_INDEX : AutoBoxingMapping.BACKWARD_TRIVIAL_INDEX).get(from)) ?
                                // tell the prediction
                                POSSIBLE : IMPOSSIBLE;
            }

            return LIKELY_POSSIBLE;
        }


        Class result = from.isPrimitive() ? AutoBoxingMapping.FORWARD_TRIVIAL_INDEX.get(from) : AutoBoxingMapping.BACKWARD_TRIVIAL_INDEX.get(from);

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
        if (null == master) {
            master = new SharedClassCache();
        }

        return master;
    }

    private SharedClassCache() {
    }
}
