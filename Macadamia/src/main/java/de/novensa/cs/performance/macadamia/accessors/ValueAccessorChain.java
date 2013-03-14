package de.novensa.cs.performance.macadamia.accessors;

import de.novensa.cs.performance.macadamia.accessors.caches.SharedClassCache;
import de.novensa.cs.performance.macadamia.messaging.ErrorMessages;

import java.lang.reflect.Method;
import java.util.*;

import static de.novensa.cs.performance.macadamia.messaging.ErrorMessages.NO_METHOD_CAN_BE_INVOKED_ON_A_PRIMITIVE_VALUE;

/**
 * Chain used to retrieve the values from call hierarchies.
 *
 * @author Daniel Schulz
 */
public class ValueAccessorChain {

    List<Object> valueAccessorChain = new ArrayList<Object>();
    private final SharedClassCache sharedClassCache = SharedClassCache.getInstance();
    private final Map<Class, LinkedHashSet<Method>> methodsCache = sharedClassCache.getCache();

    final Class basicInstance;
    Class lastSimulatedMethodInvocationsResult;

    public void addUpcomingElement(Method method) {
        if(lastSimulatedMethodInvocationsResult.isPrimitive()) {
            throw new IllegalStateException(NO_METHOD_CAN_BE_INVOKED_ON_A_PRIMITIVE_VALUE);
        }

        Method[] methods = lastSimulatedMethodInvocationsResult.getMethods();
        // caching the possible Methods per Class
        if (!methodsCache.containsKey(lastSimulatedMethodInvocationsResult)) {
            LinkedHashSet<Method> brandNewSet = new LinkedHashSet<Method>();
            Collections.addAll(brandNewSet, methods);
            methodsCache.put(lastSimulatedMethodInvocationsResult, brandNewSet);
        }

        // is Method applicable?
        if (!methodsCache.get(lastSimulatedMethodInvocationsResult)
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



    private boolean castingMaybePossible(Class from, Class to) {
        return sharedClassCache.isCastingPossibleBoolean(from, to);
    }


    // basic bean members

    @SuppressWarnings("UnusedDeclaration")
    public List<Object> getElements() {
        return valueAccessorChain;
    }

    @SuppressWarnings("UnusedDeclaration")
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
