package de.novensa.cs.performance.macadamia.accessors;

import de.novensa.cs.performance.macadamia.util.ErrorMessages;

import java.util.*;

/**
 * Makes it easy to tell AutoBoxingMappings valid apart from others. By definition the forward translation is Primitive
 * to it's instance. The backward translation therefore is instance to Primitive. You can perform a test of classes
 * being indexed here based on these indices.
 *
 * @author Daniel Schulz
 */
@SuppressWarnings("UnusedDeclaration")
public class AutoBoxingMapping {

    /**
     * Cast from Java Primitives to it's respective instances. Casts within all these cross-wise are possible iff it's
     * class is not member of the isolated set (beneath). IsolatedSet-members are changeable on their trivial index
     * way only.
     */
    private static final Map<Class, Class> FORWARD_TRIVIAL_INDEX = getForwardTrivialIndex();

    /**
     * The same as above: the only difference is the mapping from instances to it's respective Primitives.
     */
    private static final Map<Class, Class> BACKWARD_TRIVIAL_INDEX = getBackwardTrivialIndex();

    /**
     * The isolated set contains classes that are not free changeable in cross-wise manner. Members of this set can be
     * cast in the index' mapping only.
     */
    private static final LinkedHashSet<Class> ISOLATED_SET = getIsolatedSet();

    public static boolean isClassInIndex(Class clazz) {
        if (null == clazz) {
            throw new IllegalArgumentException(ErrorMessages.NULL_ARGUMENTS_NOT_ALLOWED_HERE);
        }

        return clazz.isPrimitive() ? FORWARD_TRIVIAL_INDEX.containsKey(clazz) : BACKWARD_TRIVIAL_INDEX.containsKey(clazz);
    }

    private static ClassCastPrediction isCastPossibleInternal(Class from, Class to) {

        // no cast will be performed because target state equals initial state
        if (from.equals(to)) {
            return ClassCastPrediction.POSSIBLE;
        }

        // no cross-wise castings possible
        if (ISOLATED_SET.contains(from)) {
            return ClassCastPrediction.IMPOSSIBLE;
        }

        if (isClassInIndex(from) && isClassInIndex(to)) {
            if (ISOLATED_SET.contains(from)) {
                return // pick correct index
                        to.equals((from.isPrimitive() ? FORWARD_TRIVIAL_INDEX : BACKWARD_TRIVIAL_INDEX).get(from)) ?
                                // tell the prediction
                        ClassCastPrediction.POSSIBLE : ClassCastPrediction.IMPOSSIBLE;
            }

            return ClassCastPrediction.LIKELY_POSSIBLE;
        }


        Class result = from.isPrimitive() ? FORWARD_TRIVIAL_INDEX.get(from) : BACKWARD_TRIVIAL_INDEX.get(from);

        // null == result: class is not present in it's index
        if (null == result) {
            return ClassCastPrediction.CANNOT_BE_TOLD;
        }



        if (to.equals(result)) {
            /*if (!isCastingPossible(result, to).equals(ClassCastPrediction.IMPOSSIBLE)) {

            }*/


            return ClassCastPrediction.LIKELY_POSSIBLE;
        }

        return ClassCastPrediction.CANNOT_BE_TOLD;
    }

    public static ClassCastPrediction isCastingPossible(Class from, Class to) {
        if (null == from || null == to) {
            throw new IllegalArgumentException(ErrorMessages.NULL_ARGUMENTS_NOT_ALLOWED_HERE);
        }

        return isCastPossibleInternal(from, to);

        /*
        if (isClassInIndex(from) && isClassInIndex(to) && !ISOLATED_SET.contains(from)) {
            return ClassCastPrediction.LIKELY_POSSIBLE;
        }*/
    }

    /*
    private static void canTranslate(Map<Class, Set<Class>> index, Class from, Class... to) {
        TreeSet<Class> possibleTargetClasses = new TreeSet<Class>();
        Collections.addAll(possibleTargetClasses, to);
        index.put(from, possibleTargetClasses);
    }*/

    public static Map<Class, Class> getForwardTrivialIndex() {
        Map<Class, Class> forwardIndex = new HashMap<Class, Class>();

        forwardIndex.put(boolean.class, Boolean.class);
        forwardIndex.put(float.class,   Float.class);
        forwardIndex.put(double.class,  Double.class);
        forwardIndex.put(int.class,     Integer.class);
        forwardIndex.put(byte.class,    Byte.class);
        forwardIndex.put(short.class,   Short.class);

        return forwardIndex;
    }

    public static Map<Class, Class> getBackwardTrivialIndex() {
        Map<Class, Class> backwardIndex = new HashMap<Class, Class>();

        backwardIndex.put(Boolean.class, boolean.class);
        backwardIndex.put(Float.class,   float.class);
        backwardIndex.put(Double.class,  double.class);
        backwardIndex.put(Integer.class, int.class);
        backwardIndex.put(Byte.class,    byte.class);
        backwardIndex.put(Short.class,   short.class);

        return backwardIndex;
    }

    public static LinkedHashSet<Class> getIsolatedSet() {
        LinkedHashSet<Class> isolatedSet = new LinkedHashSet<Class>();
        isolatedSet.add(boolean.class);
        isolatedSet.add(Boolean.class);
        return isolatedSet;
    }
}
