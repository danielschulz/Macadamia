package de.novensa.cs.performance.macadamia.accessors;

/**
 * Use Java's inheritance techniques to make an prediction about the casting outcomes.
 *
 * @author Daniel Schulz
 */
public abstract class AdvancedJavaCastingRules {

    public static ClassCastPrediction isCastingPossible(Class from, Class to) {

        ClassCastPrediction result = null;
        // is the target class a more general class?
        Class nextInInheritanceHierarchy = from;
        do {
            nextInInheritanceHierarchy = nextInInheritanceHierarchy.getSuperclass();
            if (to.equals(nextInInheritanceHierarchy)) {
                result = ClassCastPrediction.POSSIBLE;
            }
        } while (null != nextInInheritanceHierarchy);

        if (null != result) {
            // we found a more general type
            return result;
        }

        // is the target class an implementing interface?
        Class[] interfaces = from.getInterfaces();
        if (null != interfaces) {
            for (Class cur : interfaces) {
                if (to.equals(cur)) {
                    return ClassCastPrediction.POSSIBLE;
                }
            }
        }


        return ClassCastPrediction.IMPOSSIBLE;
    }
}
