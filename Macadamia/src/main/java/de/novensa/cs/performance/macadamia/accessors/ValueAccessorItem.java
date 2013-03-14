package de.novensa.cs.performance.macadamia.accessors;

import org.javatuples.Pair;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;

import static de.novensa.cs.performance.macadamia.messaging.ErrorMessages.NULL_ARGUMENTS_NOT_ALLOWED_HERE;

/**
 * A mapping from a method to a bunch of arguments to put in.
 *
 * @author Daniel Schulz
 */
@SuppressWarnings("UnusedDeclaration")
public class ValueAccessorItem {

    private final Pair<Method, Collection<Object>> methodToArguments;
    private final Class clazz;

    public Object performUpcomingMove(Object obj) throws InvocationTargetException, IllegalAccessException {

        // methods will be executed
        if (null != methodToArguments) {

            Collection<Object> arguments = methodToArguments.getValue1();
            Object[] argObjects = new Object[arguments.size()];
            int i = 0;
            for (Object a : argObjects) {
                argObjects[i++] = a;
            }

            return methodToArguments.getValue0().invoke(obj, argObjects);
        } else {
            // a casting will be done

            return null;
        }
    }

    // basic bean members

    public ValueAccessorItem(Method method, Collection<Object> arguments) {
        if (null == method || null == arguments) {
            throw new IllegalArgumentException(NULL_ARGUMENTS_NOT_ALLOWED_HERE);
        }

        this.methodToArguments = new Pair<Method, Collection<Object>>(method, arguments);
        this.clazz = null;
    }

    public ValueAccessorItem(Class clazz) {
        if (null == clazz) {
            throw new IllegalArgumentException(NULL_ARGUMENTS_NOT_ALLOWED_HERE);
        }

        this.methodToArguments = null;
        this.clazz = clazz;
    }

    public Pair<Method, Collection<Object>> getMethodToArguments() {
        return methodToArguments;
    }

    public Method getMethod() {
        return this.methodToArguments.getValue0();
    }

    public Collection<Object> getArguments() {
        return this.methodToArguments.getValue1();
    }

    public Class getClazz() {
        return this.clazz;
    }
}
