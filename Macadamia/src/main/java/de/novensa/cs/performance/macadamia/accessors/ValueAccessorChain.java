package de.novensa.cs.performance.macadamia.accessors;

import de.novensa.cs.performance.macadamia.util.ErrorMessages;

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
    final Class basicInstance;
    Class lastSimulatedMethodInvocationsResult;

    public void addUpcomingElement(Method method) {
        if(lastSimulatedMethodInvocationsResult.isPrimitive()) {
            throw new IllegalStateException(ErrorMessages.NO_METHOD_CAN_BE_INVOKED_ON_A_PRIMITIVE_VALUE);
        }

        Method[] methods = lastSimulatedMethodInvocationsResult.getMethods();
        // caching the possible Methods per Class
        if (!sharedClassToMethodsCache.getCache().containsKey(lastSimulatedMethodInvocationsResult.getCanonicalName())) {
            sharedClassToMethodsCache.getCache().put(lastSimulatedMethodInvocationsResult.getCanonicalName(), methods);
        }

        // is Method applicable?
        if (!isPossible(sharedClassToMethodsCache.getCache().get(lastSimulatedMethodInvocationsResult.getCanonicalName()), method)) {
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
        lastSimulatedMethodInvocationsResult = clazz;
        valueAccessorChain.add(clazz);
    }


    private boolean isPossible(Method[] methods, Method method) {
        // unfortunately @NotNull isn't making it`s job
        if (null == method || null == methods) {
            throw new IllegalArgumentException(ErrorMessages.NULL_ARGUMENTS_NOT_ALLOWED_HERE);
        }

        for (Method m : methods) {
            if (method.equals(m)) {
                return true;
            }
        }
        return false;
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
