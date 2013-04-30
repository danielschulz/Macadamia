package de.novensa.cs.performance.macadamia.examplemodels.nature;

/**
 * An example object for testing purpose.
 *
 * @author Daniel Schulz
 */
@SuppressWarnings("UnusedDeclaration")
public class Human extends LivingThings implements ToolBuilder {

    private final String name;
    private float high;

    public Human(String name, float high) {
        this.name = name;
        this.high = high;
    }

    public String getName() {
        return name;
    }

    public float getHigh() {
        return high;
    }

    public void setHigh(float high) {
        this.high = high;
    }

    @Override
    public void buildTool() {
    }

    @Override
    public long getAtomsMadeOf() {
        return (long) 10e6;
    }
}
