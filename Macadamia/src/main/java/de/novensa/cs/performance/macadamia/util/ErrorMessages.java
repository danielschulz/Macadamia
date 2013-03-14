package de.novensa.cs.performance.macadamia.util;

import java.lang.reflect.Method;

/**
 * Central store for error messages of all kinds. They're internally separated by sectioning via comments.
 *
 * @author Daniel Schulz
 */
public class ErrorMessages {

    // Self-explanatory Constants to take right away
    private static final String METHOD_NOT_INVOKABLE = "The method '%s' cannot be invoked on the Class '%s'. Please " +
            "see the code or documentation.";

    public static final String NULL_ARGUMENTS_NOT_ALLOWED_HERE = "It's not useful to paste null arguments in here.";

    public static final String NO_METHOD_CAN_BE_INVOKED_ON_A_PRIMITIVE_VALUE = "Methods cannot be a invoked on " +
            "Java Primitives. Method invocations are possible on instance objects only.";

    private static final String CASTING_MAY_CAUSE_AN_ERROR = "The casting from class '%s' to class '%s' is very " +
            "likely to fail with a ClassCastException.";


    // Methods to format a little more complex messages
    public static String getMethodNotInvokable(Method method, Class clazz) {
        return String.format(METHOD_NOT_INVOKABLE, method.toString(), clazz.getCanonicalName());
    }

    public static String getCastingMayCauseAnError(Class from, Class to) {
        return String.format(CASTING_MAY_CAUSE_AN_ERROR, from.getCanonicalName(), to.getCanonicalName());
    }
}
