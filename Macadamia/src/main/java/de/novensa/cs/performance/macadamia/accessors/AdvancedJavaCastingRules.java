package de.novensa.cs.performance.macadamia.accessors;

import de.novensa.cs.performance.macadamia.accessors.caches.ClassCastPredictionCache;
import de.novensa.cs.performance.macadamia.util.strategic.ClassCastPrediction;
import de.novensa.cs.performance.macadamia.util.Constants;

import java.util.Collections;
import java.util.LinkedHashSet;

import static de.novensa.cs.performance.macadamia.util.strategic.ClassCastPrediction.CANNOT_BE_TOLD;
import static de.novensa.cs.performance.macadamia.util.strategic.ClassCastPrediction.IMPOSSIBLE;
import static de.novensa.cs.performance.macadamia.util.strategic.ClassCastPrediction.POSSIBLE;

/**
 * Use Java's inheritance techniques to make an prediction about the casting outcomes.
 *
 * @author Daniel Schulz
 */
public abstract class AdvancedJavaCastingRules {

    public static ClassCastPrediction isCastingPossibleByInheritance(Class from, Class to,
                     ClassCastPredictionCache<Class, Class, ClassCastPrediction> classCastPrediction) {

        if (classCastPrediction.hasKey(from, to)) {
            return classCastPrediction.get(from, to);
        } else {
            ClassCastPrediction result = isCastingPossibleByInheritance(from, to);
            classCastPrediction.add(from, to, result);
            return result;
        }
    }

    private static ClassCastPrediction isCastingPossibleByInheritance(Class from, Class to) {

        ClassCastPrediction result = null;

        Class[] directInterfaces = from.getInterfaces();
        LinkedHashSet<Class> inheritedInterfaces = new LinkedHashSet<Class>();
        Collections.addAll(inheritedInterfaces, directInterfaces);


        // is the target class a more general class?
        Class nextInInheritanceHierarchy = from;
        do {
            nextInInheritanceHierarchy = nextInInheritanceHierarchy.getSuperclass();
            if (null != nextInInheritanceHierarchy) {
                Collections.addAll(inheritedInterfaces, nextInInheritanceHierarchy.getInterfaces());
            }

            if (to.equals(nextInInheritanceHierarchy)) {
                result = POSSIBLE;
            }
        } while (null != nextInInheritanceHierarchy);

        if (null != result) {
            // we found a more general type
            return result;
        }


        // is the target class an implementing interface?
        if (Constants.OBJECT.equals(from) && !to.isPrimitive()) {
            return CANNOT_BE_TOLD;
        } else {
            return inheritedInterfaces.contains(to) ? POSSIBLE : IMPOSSIBLE;
        }
    }
}
