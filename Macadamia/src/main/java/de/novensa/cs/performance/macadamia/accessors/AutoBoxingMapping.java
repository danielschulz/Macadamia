package de.novensa.cs.performance.macadamia.accessors;

import de.novensa.cs.performance.macadamia.util.ErrorMessages;

import java.util.*;

import static de.novensa.cs.performance.macadamia.accessors.ClassCastPrediction.CANNOT_BE_TOLD;

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
    public static final Map<Class, Class> FORWARD_TRIVIAL_INDEX = getForwardTrivialIndex();

    /**
     * The same as above: the only difference is the mapping from instances to it's respective Primitives.
     */
    public static final Map<Class, Class> BACKWARD_TRIVIAL_INDEX = getBackwardTrivialIndex();

    /**
     * The isolated set contains classes that are not free changeable in cross-wise manner. Members of this set can be
     * cast in the index' mapping only.
     */
    public static final LinkedHashSet<Class> ISOLATED_SET = getIsolatedSet();

    private SharedClassCache sharedClassCache = SharedClassCache.getInstance();


    public static boolean isClassInIndex(Class clazz) {
        if (null == clazz) {
            throw new IllegalArgumentException(ErrorMessages.NULL_ARGUMENTS_NOT_ALLOWED_HERE);
        }

        return clazz.isPrimitive() ? FORWARD_TRIVIAL_INDEX.containsKey(clazz) : BACKWARD_TRIVIAL_INDEX.containsKey(clazz);
    }



    public ClassCastPrediction isCastingPossible(Class from, Class to) {
        if (null == from || null == to) {
            throw new IllegalArgumentException(ErrorMessages.NULL_ARGUMENTS_NOT_ALLOWED_HERE);
        }

        ClassCastPrediction autoBoxingResult = sharedClassCache.isCastPossibleInternal(from, to);
        if (!CANNOT_BE_TOLD.equals(autoBoxingResult)) {
            // we have an answer
            return autoBoxingResult;
        } else {
            // if auto boxing cannot be sure enough go on using inheritance, implementation´s, and other techniques
            return AdvancedJavaCastingRules.isCastingPossible(from, to);
        }
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
