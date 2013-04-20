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

    // comparison logic
    public int compareTo(N anotherNumber) {

        if (this.number instanceof Long) {
            return (this.number.longValue() < anotherNumber.longValue()) ?
                    -1 : ((this.number.longValue() == anotherNumber.longValue()) ? 0 : 1);

        } else if (this.number instanceof Integer) {
            return (this.number.intValue() < anotherNumber.intValue()) ?
                    -1 : ((this.number.intValue() == anotherNumber.intValue()) ? 0 : 1);

        } else if (this.number instanceof Float) {
            return (this.number.floatValue() < anotherNumber.floatValue()) ?
                    -1 : ((this.number.floatValue() == anotherNumber.floatValue()) ? 0 : 1);

        } else if (this.number instanceof Double) {
            return (this.number.doubleValue() < anotherNumber.doubleValue()) ?
                    -1 : ((this.number.doubleValue() == anotherNumber.doubleValue()) ? 0 : 1);

        } else if (this.number instanceof Short) {
            return (this.number.shortValue() < anotherNumber.shortValue()) ?
                    -1 : ((this.number.shortValue() == anotherNumber.shortValue()) ? 0 : 1);

        } else if (this.number instanceof Byte) {
            return (this.number.byteValue() < anotherNumber.byteValue()) ?
                    -1 : ((this.number.byteValue() == anotherNumber.byteValue()) ? 0 : 1);
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
