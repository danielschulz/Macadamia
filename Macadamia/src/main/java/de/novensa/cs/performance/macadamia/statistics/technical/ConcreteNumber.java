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
    
    @SuppressWarnings("UnusedDeclaration")
    public int compareTo(N anotherNumber) {
        return compareTo(this.number, anotherNumber);
    }

    // comparison logic
    @SuppressWarnings({"FinalStaticMethod", "unchecked"})
    public static final <N extends Number> int compareTo(final N oneNumber, final N anotherNumber) {

        // extract values
        final N oneNumberInner;
        if (oneNumber instanceof ConcreteNumber) {
            oneNumberInner = (N) ((ConcreteNumber) oneNumber).getValue();
        } else {
            oneNumberInner = oneNumber;
        }


        final N anotherNumberInner;
        if (anotherNumber instanceof ConcreteNumber) {
            anotherNumberInner = (N) ((ConcreteNumber) anotherNumber).getValue();
        } else {
            anotherNumberInner = anotherNumber;
        }
        
        

        // compare them
        if (oneNumberInner instanceof Long) {
            return (oneNumberInner.longValue() < anotherNumberInner.longValue()) ?
                    -1 : ((oneNumberInner.longValue() == anotherNumberInner.longValue()) ? 0 : 1);

        } else if (oneNumberInner instanceof Integer) {
            return (oneNumberInner.intValue() < anotherNumberInner.intValue()) ?
                    -1 : ((oneNumberInner.intValue() == anotherNumberInner.intValue()) ? 0 : 1);

        } else if (oneNumberInner instanceof Float) {
            return (oneNumberInner.floatValue() < anotherNumberInner.floatValue()) ?
                    -1 : ((oneNumberInner.floatValue() == anotherNumberInner.floatValue()) ? 0 : 1);

        } else if (oneNumberInner instanceof Double) {
            return (oneNumberInner.doubleValue() < anotherNumberInner.doubleValue()) ?
                    -1 : ((oneNumberInner.doubleValue() == anotherNumberInner.doubleValue()) ? 0 : 1);

        } else if (oneNumberInner instanceof Short) {
            return (oneNumberInner.shortValue() < anotherNumberInner.shortValue()) ?
                    -1 : ((oneNumberInner.shortValue() == anotherNumberInner.shortValue()) ? 0 : 1);

        } else if (oneNumberInner instanceof Byte) {
            return (oneNumberInner.byteValue() < anotherNumberInner.byteValue()) ?
                    -1 : ((oneNumberInner.byteValue() == anotherNumberInner.byteValue()) ? 0 : 1);
        }

        throw new IllegalStateException(ErrorMessages.NO_INSTANCE_MATCHES);
    }
    
    public final Number getValue() {

        if (this.number instanceof Long) {
            return this.number.longValue();

        } else if (this.number instanceof Integer) {
            return this.number.longValue();
            
        } else if (this.number instanceof Float) {
            return this.number.longValue();
            
        } else if (this.number instanceof Double) {
            return this.number.longValue();
            
        } else if (this.number instanceof Short) {
            return this.number.longValue();
            
        } else if (this.number instanceof Byte) {
            return this.number.longValue();
        }

        throw new IllegalStateException(ErrorMessages.NO_INSTANCE_MATCHES);
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
