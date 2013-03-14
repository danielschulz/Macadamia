package de.novensa.cs.performance.macadamia.accessors;

import java.util.Collections;
import java.util.LinkedHashSet;

/**
 * Use Java's inheritance techniques to make an prediction about the casting outcomes.
 *
 * @author Daniel Schulz
 */
public abstract class AdvancedJavaCastingRules {

    public static ClassCastPrediction isCastingPossible(Class from, Class to) {

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
                result = ClassCastPrediction.POSSIBLE;
            }
        } while (null != nextInInheritanceHierarchy);

        if (null != result) {
            // we found a more general type
            return result;
        }

        // is the target class an implementing interface?

        if (null != inheritedInterfaces) {
            for (Class cur : inheritedInterfaces) {
                if (to.equals(cur)) {
                    return ClassCastPrediction.POSSIBLE;
                }
            }
        }


        return ClassCastPrediction.IMPOSSIBLE;
    }
}
