package de.novensa.cs.performance.macadamia.testUtils;

/**
 * Provide test error messages.
 *
 * @author Daniel Schulz
 */
public interface TestUtilErrorMessages {

    public static final String LIST_EXPECTED_LIST_IS_NULL =
            "The expected list was null but the result not.";

    public static final String LIST_RESULT_LIST_IS_NULL =
            "The result list was null but the expected list was not null.";

    public static final String LIST_SIZES_DO_NOT_MATCH =
            "The expected list size was %s but the result has %s items.";

    public static final String COMPARING_ITEM_MISMATCH =
            "The expected item in %s was %s but the result was %s.";
}
