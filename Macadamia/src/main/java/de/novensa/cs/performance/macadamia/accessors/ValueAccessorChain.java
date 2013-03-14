package de.novensa.cs.performance.macadamia.accessors;

import de.novensa.cs.performance.macadamia.util.Constants;
import de.novensa.cs.performance.macadamia.util.ErrorMessages;
import org.javatuples.KeyValue;

import java.lang.reflect.Method;
import java.util.*;

/**
 * Chain used to retrieve the values from call hierarchies.
 *
 * @author Daniel Schulz
 */
@SuppressWarnings("UnusedDeclaration")
public class ValueAccessorChain {

    List<Object> valueAccessorChain = new ArrayList<Object>();
    private SharedClassToMethodsCache sharedClassToMethodsCache = SharedClassToMethodsCache.getInstance();
    private LinkedHashSet<Method> possibleMethodsByClass = new LinkedHashSet<Method>();

    final Class basicInstance;
    Class lastSimulatedMethodInvocationsResult;

    public void addUpcomingElement(Method method) {
        if(lastSimulatedMethodInvocationsResult.isPrimitive()) {
            throw new IllegalStateException(ErrorMessages.NO_METHOD_CAN_BE_INVOKED_ON_A_PRIMITIVE_VALUE);
        }

        Method[] methods = lastSimulatedMethodInvocationsResult.getMethods();
        // caching the possible Methods per Class
        if (!sharedClassToMethodsCache.getCache().containsKey(lastSimulatedMethodInvocationsResult.getCanonicalName())) {
            LinkedHashSet<Method> brandNewSet = new LinkedHashSet<Method>();
            Collections.addAll(brandNewSet, methods);
            sharedClassToMethodsCache.getCache().put(lastSimulatedMethodInvocationsResult.getCanonicalName(), brandNewSet);
        }

        // is Method applicable?
        if (!sharedClassToMethodsCache.getCache().get(lastSimulatedMethodInvocationsResult.getCanonicalName())
                .contains(method)) {
            throw new IllegalStateException(
                    ErrorMessages.getMethodNotInvokable(method, lastSimulatedMethodInvocationsResult));
        } else {
            lastSimulatedMethodInvocationsResult = method.getReturnType();
        }

        // add to chain
        valueAccessorChain.add(method);
    }

    /**
     * This represents a cast to this instance onto the now inplace generated instance in the chain.
     * @param clazz The Class to cast to
     */
    public void addUpcomingElement(Class clazz) {

        // make a basic test if casting will be possible here
        if (!castingMaybePossible(lastSimulatedMethodInvocationsResult, clazz)) {
            throw new IllegalStateException(
                    ErrorMessages.getCastingMayCauseAnError(lastSimulatedMethodInvocationsResult, clazz));
        }

        lastSimulatedMethodInvocationsResult = clazz;
        valueAccessorChain.add(clazz);
    }

    private static boolean castingMaybePossible(Class from, Class to) {

        if (null == from || null == to) {
            throw new IllegalStateException(ErrorMessages.NULL_ARGUMENTS_NOT_ALLOWED_HERE);
        }

        // everything can be cast to Object iff to is no Primitive
        if (Constants.OBJECT.equals(from) && !to.isPrimitive()) {
            return true;
        }


        // auto-unboxing from objects to their primitives and vice-versa




        // is the target class a generalized class? --> likely possible
        // is the target class an implementation of this interface? --> likely possible



        return true;
    }


    // basic bean members

    public List<Object> getElements() {
        return valueAccessorChain;
    }

    public Iterator<Object> getIterator() {
        return valueAccessorChain.iterator();
    }

    public ValueAccessorChain(Class clazz) {
        this.basicInstance = clazz;
        // for evaluation reasons: when the next upcoming elements where added the new base class has to be present to
        // check iff the method is invokable onto this instance
        this.lastSimulatedMethodInvocationsResult = clazz;
    }
}
