package de.novensa.cs.performance.macadamia.statistics.technical;

import de.novensa.cs.performance.macadamia.messaging.ErrorMessages;

/**
 * This implements a concrete implementation of the abstract <code>Number</code> class.
 *
 * @author Daniel Schulz
 */
public class ConcreteNumber<N extends Number> extends Number {

    // member
    private final Number number;


    // constructor
    public ConcreteNumber(final Number number) {
        this.number = number;
    }
    
    public int compareTo(N anotherNumber) {
        return compareTo(this.number, anotherNumber);
    }

    // comparison logic
    @SuppressWarnings("FinalStaticMethod")
    public static final <N extends Number> int compareTo(final N oneNumber, final N anotherNumber) {

        if (oneNumber instanceof Long) {
            return (oneNumber.longValue() < anotherNumber.longValue()) ?
                    -1 : ((oneNumber.longValue() == anotherNumber.longValue()) ? 0 : 1);

        } else if (oneNumber instanceof Integer) {
            return (oneNumber.intValue() < anotherNumber.intValue()) ?
                    -1 : ((oneNumber.intValue() == anotherNumber.intValue()) ? 0 : 1);

        } else if (oneNumber instanceof Float) {
            return (oneNumber.floatValue() < anotherNumber.floatValue()) ?
                    -1 : ((oneNumber.floatValue() == anotherNumber.floatValue()) ? 0 : 1);

        } else if (oneNumber instanceof Double) {
            return (oneNumber.doubleValue() < anotherNumber.doubleValue()) ?
                    -1 : ((oneNumber.doubleValue() == anotherNumber.doubleValue()) ? 0 : 1);

        } else if (oneNumber instanceof Short) {
            return (oneNumber.shortValue() < anotherNumber.shortValue()) ?
                    -1 : ((oneNumber.shortValue() == anotherNumber.shortValue()) ? 0 : 1);

        } else if (oneNumber instanceof Byte) {
            return (oneNumber.byteValue() < anotherNumber.byteValue()) ?
                    -1 : ((oneNumber.byteValue() == anotherNumber.byteValue()) ? 0 : 1);
        }

        throw new IllegalStateException(ErrorMessages.COMPARISON_WAS_NOT_POSSIBLE);
    }


    // super implementations
    @Override
    public long longValue() {
        return this.number.longValue();
    }

    @Override
    public int intValue() {
        return this.number.intValue();
    }

    @Override
    public float floatValue() {
        return this.number.floatValue();
    }

    @Override
    public double doubleValue() {
        return this.number.doubleValue();
    }

    @Override
    public short shortValue() {
        return this.number.shortValue();
    }

    @Override
    public byte byteValue() {
        return this.number.byteValue();
    }
}
