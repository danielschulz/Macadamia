package de.novensa.cs.performance.macadamia.ExampleModels.Nature;

/**
 * An example object for testing purpose.
 *
 * @author Daniel Schulz
 */
public class Human extends LivingThings {

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
}
